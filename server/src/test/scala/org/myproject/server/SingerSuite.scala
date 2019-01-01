package org.myproject.server

import org.scalatest.FunSuite

class SingerSuite extends FunSuite {

  test("sing") {

    new Singer().sing()
  }
}
