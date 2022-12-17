package machine

import scala.io.StdIn.readInt

object CoffeeMachine extends App {
  println("Write how many cups of coffee you will need:")
  val cupsOfCoffee = readInt
  println(s"For $cupsOfCoffee cups of coffee you will need:")
  println(
    s"""${cupsOfCoffee * 200} ml of water
       |${cupsOfCoffee * 50} ml of milk
       |${cupsOfCoffee * 15} g of coffee beans
       |""".stripMargin)
}
