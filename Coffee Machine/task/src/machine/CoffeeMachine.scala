package machine

import scala.io.StdIn._

object CoffeeMachine extends App {
  val WATER = "water"
  val MILK = "milk"
  val BEANS = "beans"
  val CUPS = "cups"
  val MONEY = "money"

  var availableWater = 400
  var availableMilk = 540
  var availableBeans = 120
  var availableCups = 9
  var availableMoney = 550

//  val availableResources: Map[String, Int] = Map("water" -> 400, "milk" -> 540, "beans" -> 120, "cups" -> 9,
//    "money" -> 550)

//  def printSupplies(): Unit =
//    println(
//      s"""The coffee machine has:
//         |${availableResources("water")} ml of water
//         |${availableResources("milk")} ml of milk
//         |${availableResources("beans")} g of coffee beans
//         |${availableResources("cups")} disposable cups
//         |$$${availableResources("money")} of money
//         |""".stripMargin)

  def printSupplies(): Unit =
    println(
      s"""The coffee machine has:
         |$availableWater ml of water
         |$availableMilk ml of milk
         |$availableBeans g of coffee beans
         |$availableCups disposable cups
         |$$$availableMoney of money
         |""".stripMargin)

//  def checkWhatOut(resource: String, amount: Int): String = {
//    if (availableResources(resource) - amount >= 0) "" else resource
//  }

  def checkWhatOut(water: Int, milk: Int, beans: Int): String = {
//    if (availableResources("water") - water < 0) "water"
//    else if (availableResources("milk") - milk < 0) "milk"
//    else if (availableResources("beans") - beans < 0) "beans"
//    else if (availableResources("cups") - 1 < 0) "cups"
    if (availableWater - water < 0) WATER
      else if (availableMilk - milk < 0) MILK
      else if (availableBeans - beans < 0) BEANS
      else if (availableCups - 1 < 0) CUPS
    else ""
  }

  def buyCoffee(water: Int, milk: Int, beans: Int, money: Int): Unit = {
    val notEnough = checkWhatOut(water, milk, beans)
    if (notEnough.nonEmpty) println(s"Sorry, not enough $notEnough!\n")
    else {
      println("I have enough resources, making you a coffee!\n")
//      availableResources + ("water" -> {availableResources("water") - water})
//      availableResources + ("milk" -> {availableResources("milk") - milk})
//      availableResources + ("beans" -> {availableResources("beans") - beans})
//      availableResources + ("cups" -> {availableResources("cups") - 1})
//      availableResources + ("money" -> {availableResources("money") + money})
      availableWater -= water
      availableMilk -= milk
      availableBeans -= beans
      availableCups -= 1
      availableMoney += money
    }
  }

  def buy(): Unit = {
    val typeOfCoffee = readLine("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
      "back - to main menu:\n")
    typeOfCoffee match {
      case "1" => buyCoffee(250, 0, 16, 4)
      case "2" => buyCoffee(350, 75, 20, 7)
      case "3" => buyCoffee(200, 100, 12, 6)
      case _ => println()
    }
  }
  def fill(): Unit = {
    val waterToAdd = readLine("Write how many ml of water you want to add:\n").toInt
    val milkToAdd = readLine("Write how many ml of milk you want to add:\n").toInt
    val beansToAdd = readLine("Write how many grams of coffee beans you want to add:\n").toInt
    val cupsToAdd = readLine("Write how many disposable cups you want to add:\n").toInt
//    availableResources + ("water" -> {availableResources("water") + waterToAdd})
//    availableResources + ("milk" -> {availableResources("milk") + milkToAdd})
//    availableResources + ("beans" -> {availableResources("beans") + beansToAdd})
//    availableResources + ("cups" -> {availableResources("cups") + cupsToAdd})
    availableWater += waterToAdd
    availableMilk += milkToAdd
    availableBeans += beansToAdd
    availableCups += cupsToAdd
    println()
  }
  def take(): Unit = {
//    println(s"I gave you $$${availableResources("money")}")
//    availableResources + ("money" -> 0)
    println(s"I gave you $$$availableMoney\n")
    availableMoney = 0
  }

  var action = readLine("Write action (buy, fill, take, remaining, exit):\n")
  while (action != "exit") {
    action match {
      case "buy" => buy()
      case "fill" => fill()
      case "take" => take()
      case "remaining" => printSupplies()
    }
    action = readLine("Write action (buy, fill, take, remaining, exit):\n")
  }
}
