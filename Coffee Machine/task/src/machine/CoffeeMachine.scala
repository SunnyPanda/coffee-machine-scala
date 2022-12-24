package machine

import scala.io.StdIn._
import machine.CoffeeMachineProcessor.processCommand

object CoffeeMachine extends App {

//  def main(args: Array[String]): Unit = {
//
//  }
  var command = readLine("Write action (buy, fill, take, remaining, exit):\n")
  while (command != "exit") {
    processCommand(command)
    command = readLine()
  }
}
