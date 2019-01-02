package org.myproject.server

import org.myproject.common.CaseChanger

class Greeter {

  def greet(obj: Any): String = obj match {
    case world: World => new CaseChanger().toLowerCase("Hello World!")
    case _ => "Uhh excuse me?"
  }
}
