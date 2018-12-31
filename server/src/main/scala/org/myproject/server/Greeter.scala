package org.myproject.server

class Greeter {

  def greet(obj: Any): String = obj match {
    case world: World => "Hello World!"
    case _ => "Uhh excuse me?"
  }
}
