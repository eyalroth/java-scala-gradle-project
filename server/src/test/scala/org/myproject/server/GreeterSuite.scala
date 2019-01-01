package org.myproject.server

import org.scalatest.FunSuite

class GreeterSuite extends FunSuite {

  test("greet world") {

    new Greeter().greet(new World)
  }

  test("greet something else") {

    new Greeter().greet(1)
  }
}
