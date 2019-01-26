package org.myproject.analytics

import spray.json.DefaultJsonProtocol._
import spray.json._

class Reporter {

  def report(rawData: String): Report = {

    val json = rawData.parseJson

    val id = json.asJsObject.getFields("id").head.convertTo[Long]
    val count = json.asJsObject.getFields("count").head.convertTo[Int]

    Report(id, count)
  }

  class InnerReporter {

    def lala(): Unit = {

      val x = 1 + 1
      x
    }
  }
}

case class Report(id: Long, count: Int)