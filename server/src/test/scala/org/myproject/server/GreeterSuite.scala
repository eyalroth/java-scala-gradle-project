package org.myproject.server

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GreeterSuite extends FunSuite {

  test("greet world") {

    new Greeter().greet(new World)
  }

  test("greet something else") {

    new Greeter().greet(1)
  }
}
