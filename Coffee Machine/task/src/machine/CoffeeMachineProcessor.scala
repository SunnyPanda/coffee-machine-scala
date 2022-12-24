package machine

object CoffeeMachineProcessor {

  val STATE_READY = "READY"
  val STATE_CHOOSE = "CHOOSE"
  val STATE_FILL_WATER = "FILL_WATER"
  val STATE_FILL_MILK = "FILL_MILK"
  val STATE_FILL_BEANS = "FILL_BEANS"
  val STATE_FILL_CUPS = "FILL_CUPS"

  var state: String = STATE_READY

  val WATER = "water"
  val MILK = "milk"
  val BEANS = "beans"
  val CUPS = "cups"

  var availableWater = 400
  var availableMilk = 540
  var availableBeans = 120
  var availableCups = 9
  var availableMoney = 550

  def askChooseAction(): Unit = println("Write action (buy, fill, take, remaining, exit):")

  def askTypeOfCoffee(): Unit = {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    state = STATE_CHOOSE
  }

  def askToFillWater(): Unit = {
    println("Write how many ml of water you want to add:")
    state = STATE_FILL_WATER
  }

  def fillWater(amount: String): Unit = {
    availableWater += amount.toInt
    println("Write how many ml of milk you want to add:")
    state = STATE_FILL_MILK
  }

  def fillMilk(amount: String): Unit = {
    availableMilk += amount.toInt
    println("Write how many grams of coffee beans you want to add:")
    state = STATE_FILL_BEANS
  }

  def fillBeans(amount: String): Unit = {
    availableBeans += amount.toInt
    println("Write how many disposable cups you want to add:")
    state = STATE_FILL_CUPS
  }

  def fillCups(amount: String): Unit = {
    availableCups += amount.toInt
    println()
    state = STATE_READY
    askChooseAction()
  }

  def take(): Unit = {
    println(s"I gave you $$$availableMoney\n")
    availableMoney = 0
    askChooseAction()
  }

  def chooseAction(action: String): Unit = {
    action match {
      case "buy" => askTypeOfCoffee()
      case "fill" => askToFillWater()
      case "take" => take()
      case "remaining" => printSupplies()
    }
  }

  def printSupplies(): Unit = {
    println(
      s"""The coffee machine has:
         |$availableWater ml of water
         |$availableMilk ml of milk
         |$availableBeans g of coffee beans
         |$availableCups disposable cups
         |$$$availableMoney of money
         |""".stripMargin)

    askChooseAction()
  }

  def checkWhatOut(water: Int, milk: Int, beans: Int): String = {
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
      availableWater -= water
      availableMilk -= milk
      availableBeans -= beans
      availableCups -= 1
      availableMoney += money
    }
  }

  def buy(typeOfCoffee: String): Unit = {
    typeOfCoffee match {
      case "1" => buyCoffee(250, 0, 16, 4)
      case "2" => buyCoffee(350, 75, 20, 7)
      case "3" => buyCoffee(200, 100, 12, 6)
      case _ => println()
    }
    state = STATE_READY
    askChooseAction()
  }

  def processCommand(command: String): Unit = {
    state match {
      case STATE_READY => chooseAction(command)
      case STATE_CHOOSE => buy(command)
      case STATE_FILL_WATER => fillWater(command)
      case STATE_FILL_MILK => fillMilk(command)
      case STATE_FILL_BEANS => fillBeans(command)
      case STATE_FILL_CUPS => fillCups(command)
    }
  }
}
