package org.myproject.common

import java.io.InputStream
import java.net.URL
import java.util.jar.{Attributes, Manifest}

import scala.util.Try

object VersionReader {

  private val CUSTOM_MANIFEST_SECTION = "Build-Details"
  private val BUILD_DATE_ATTRIBUTE = "Implementation-Date"
  private val GIT_REVISION_ATTRIBUTE = "Implementation-Revision"

  def readVersionData(): Option[VersionData] = {

    findManifestStream().map { is =>
      try {
        val manifest = new Manifest(is)

        val version = manifest.getMainAttributes.getValue(Attributes.Name.SPECIFICATION_VERSION)
        val buildNumber = manifest.getMainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION)
        val buildDate = manifest.getAttributes(CUSTOM_MANIFEST_SECTION).getValue(BUILD_DATE_ATTRIBUTE)
        val gitRevision = manifest.getAttributes(CUSTOM_MANIFEST_SECTION).getValue(GIT_REVISION_ATTRIBUTE)

        new VersionData(version, buildDate, buildNumber, gitRevision)
      }
      finally {
        Try(is.close())
      }
    }
  }

  // taken from https://stackoverflow.com/a/1273432/114626
  private def findManifestStream(): Option[InputStream] = {

    val clazz = VersionReader.getClass
    val className = clazz.getSimpleName + ".class"
    val classPath = clazz.getResource(className).toString

    if (classPath.startsWith("jar")) {
      val manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
      Option(new URL(manifestPath).openStream())
    } else {
      None
    }
  }

}

class VersionData(version: String, buildDate: String, buildNumber: String, gitRevision: String) {

  override def toString: String = {
    s"""Version: $version
       |Date: $buildDate
       |Build: $buildNumber
       |Revision: $gitRevision""".stripMargin
  }
}