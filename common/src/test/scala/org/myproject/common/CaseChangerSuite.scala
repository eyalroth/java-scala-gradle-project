package org.myproject.common

import org.scalatest.FunSuite

class CaseChangerSuite extends FunSuite {

  test("toLowerCase") {

    new CaseChanger().toLowerCase("hehe")
  }
}
