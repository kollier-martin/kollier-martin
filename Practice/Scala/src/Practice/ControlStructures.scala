package io.beansprout
package Practice

import models.Person

import scala.io.StdIn.readLine
import scala.util.Random

@main
def main(): Unit = {
  val controlStructures = new ControlStructures
  controlStructures.doThings()
}

class ControlStructures {
  private val ints: List[Int] = List(1, 2, 3, 4, 5)
  private val names = List("John", "James", "Jonah", "Jacob")
  private var min, max = 0

  def doThings(): Unit = {
    min = Random.between(-10, 20)
    max = Random.between(-10, 20)

    // if/else statement
    if (min > max) {
      println(s"The provided min:$min is greater than the max:$max")
    } else if (max < 0 || min < 0) {
      println("This application can not accept negatives.")
    } else {
      println(s"The provided max:$max is greater than the min:$min\n")
    }

    // for loop
    println("Beginning 0 to 4 loop...")
    for i <- 0 to 4 do print(s"$i ")
    println("\nFinished.\n")

    println("Beginning to print integers from list...")
    for i <- ints do print(s"$i ")
    println("\nFinished.\n")

    println("Printing all names with a length greater than 4...")
    for name <- names
        if name.length > 4
    do
      println(s"$name")
    println("Finished.\n")

    println("Printing the integer list with all values multiplied by 2...")
    for name <- names
        if name.length > 4
    do
      println(s"$name")
    println("Finished.\n")

    // match statement
    print("Input 'Y' or 'N': ")
    val input = readLine()

    input match
      case "Y" => println("Yes has been received as input.")
      case "N" => println("No has been received as input.")
      case _ => println("Incorrect input given.")

    println()

    // person match
    val person = Person("Yogi")

    person.getName match
      case "Yogi" =>
        println("My name is Yogi.")
        println("Do you have a pic-a-nic basket?")

      case _ => println("I'm not a cartoon bear :(\n")
  }
}
