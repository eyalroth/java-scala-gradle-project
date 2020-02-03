package org.myproject.mix

class GreeterSuite extends munit.FunSuite {

  test("greet world") {

    new Greeter().greet(new World)
  }

  test("greet something else") {

    new Greeter().greet(1)
  }
}
