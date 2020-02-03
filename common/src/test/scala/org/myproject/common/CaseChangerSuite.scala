package org.myproject.common

class CaseChangerSuite extends munit.FunSuite {

  test("toLowerCase") {

    new CaseChanger().toLowerCase("hehe")
  }
}
