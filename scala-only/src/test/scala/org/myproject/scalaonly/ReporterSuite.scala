package org.myproject.scalaonly

class ReporterSuite extends munit.FunSuite {

  test("report"){

    val report = new Reporter().report("""{ "id": 1, "count": 2}""")

    assertEquals(Report(1, 2), report)
  }
}
