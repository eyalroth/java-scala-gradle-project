package org.myproject.scalaonly

import org.myproject.common.{Printer, VersionReader}

import scala.util.control.NonFatal

object ScalaOnlyHelloWorld extends App {

  val printer = new Printer
  val reporter = new Reporter

  val versionData = VersionReader.readVersionData().map(_.toString).getOrElse("No version info")
  printer.print(versionData)

  try {
    val report = reporter.report(scala.io.StdIn.readLine("Give me JSON please :)"))
    printer.print(report.toString)
  } catch {
    case NonFatal(e) =>
      printer.print("Silly rabbit, the JSON is wrong!")
  }
}
