package machine

import scala.io.StdIn._
import machine.CoffeeMachineProcessor.processCommand

object CoffeeMachine extends App {
  var command = readLine("Write action (buy, fill, take, remaining, exit):\n")
  while (command != "exit") {
    processCommand(command)
    command = readLine()
  }
}
