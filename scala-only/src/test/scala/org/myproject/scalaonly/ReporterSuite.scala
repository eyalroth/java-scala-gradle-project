package org.myproject.scalaonly

import org.scalatest.FunSuite

class ReporterSuite extends FunSuite {

  test("report"){

    val report = new Reporter().report("""{ "id": 1, "count": 2}""")

    assertResult(Report(1, 2))(report)
  }
}
