package org.myproject.common.tests

import java.util.function.Predicate

import org.junit.platform.commons.util.{ClassFilter, ReflectionUtils}
import org.scalatest.Suite

import scala.collection.JavaConverters._
import scala.util.control.NonFatal

trait MainModuleSuite extends Suite {

  override lazy val nestedSuites: collection.immutable.IndexedSeq[Suite] = {

    def isSuiteClass(clazz: Class[_]): Boolean =
      this.getClass != clazz &&
        classOf[Suite].isAssignableFrom(clazz) &&
        ReflectionUtils.isPublic(clazz) &&
        !ReflectionUtils.isAbstract(clazz) &&
        !ReflectionUtils.isInnerClass(clazz)

    val thisPackageName = this.getClass.getPackage.getName

    val suiteClasses = ReflectionUtils.findAllClassesInPackage(thisPackageName, ClassFilter.of(new Predicate[Class[_]] {
      override def test(t: Class[_]): Boolean = isSuiteClass(t)
    }))

    suiteClasses.asScala.toIndexedSeq.map { clazz =>
      try {
        clazz.getConstructor().newInstance().asInstanceOf[Suite]
      } catch {
        case NonFatal(e) =>
          throw new IllegalArgumentException(s"${clazz.getName} must have a public no-arg constructor", e)
      }
    }
  }
}
