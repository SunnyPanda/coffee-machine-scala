package machine

import scala.io.StdIn.readInt

object CoffeeMachine extends App {
  println("Write how many ml of water the coffee machine has:")
  val water = readInt()
  println("Write how many ml of milk the coffee machine has:")
  val milk = readInt()
  println("Write how many grams of coffee beans the coffee machine has:")
  val beans = readInt()

  println("Write how many cups of coffee you will need:")
  val cupsOfCoffeeNeeded = readInt()
  val cupsOfCoffeeCanMake: Int = List(water / 200, milk / 50, beans / 15).min
  val difference = cupsOfCoffeeCanMake - cupsOfCoffeeNeeded

  if (difference == 0) {
    println("Yes, I can make that amount of coffee")
  } else if (difference > 0) {
    println(s"Yes, I can make that amount of coffee (and even $difference more than that)")
  } else {
    println(s"No, I can make only $cupsOfCoffeeCanMake cup(s) of coffee")
  }
}
