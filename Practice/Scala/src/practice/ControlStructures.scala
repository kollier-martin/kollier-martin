package io.beansprout
package practice

import models.Person

import scala.io.StdIn.readLine
import scala.util.Random

class ControlStructures:
  private val ints: List[Int] = List(1, 2, 3, 4, 5)
  private val names = List("John", "James", "Jonah", "Jacob")
  private val min = Random.between(-10, 20)
  private val max = Random.between(-10, 20)

  /**
   * Runs all if expressions
   */
  def runIfExpressions(): Unit =
    //if construct
    if min > 0 then
      println(s"Min is greater than 0.")
      println(s"Value: $min\n")
    end if // (end if is optional)

    // if/else statement
    if min > max then
      println(s"The provided min, $min, is greater than the max, $max.\n")
    else if max < 0 || min < 0 then
      println("This application can not accept negatives.\n")
    else
      println(s"The provided max, $max, is greater than the min, $min.\n")

  /**
   * Runs all for loops
   */
  def runForLoops(): Unit =
    // Count fro 0 to 4
    println("Beginning 0 to 4 loop...")
    for i <- 0 to 4 do print(s"$i ")
    println("\nFinished.\n")

    // Print all integers in the list
    println("Beginning to print integers from list...")
    for i <- ints do print(s"$i ")
    println("\nFinished.\n")

    // Print all names where there are more than 4 letters using guards
    println("Printing all names with a length greater than 4...")
    for name <- names
        if name.length > 4
    do
      println(s"$name")
    println("Finished.\n")

    // Printing all integers multiplied by 2
    println("Printing the integer list with all values multiplied by 2...")
    for int <- ints
      do
        println(s"Old Value: $int, New Value: ${int * 2}")
    println("Finished.\n")

    // Printing all integers halved using yield
    println("Printing the integer list with all values halved...")
    val halvedValues = for int <- ints yield int * 0.5
    println(s"Old List: $ints")
    println(s"New List: $halvedValues")
    println("Finished.\n")

    // Multiple Generators
    for
      i <- 1 to 2
      j <- 'a' to 'b'
      k <- 2 to 4
    do
      println(s"i = $i, j = $j, k = $k")

    end for
    println()

  /**
   * Runs all match expressions
   */
  def runMatchExpressions(): Unit =
    // match statement
    print("Input 'Y' or 'N': ")
    var input = readLine()

    input match
      case "Y" => println("Yes has been received as input.")
      case "N" => println("No has been received as input.")
      case _ => println("Incorrect input given.")

    println()

    // person match
    print("What is your name? ")
    input = readLine()
    val person = Person(input)

    person.name match
      case "Yogi" =>
        println("Hello, Yogi. I heard that you're looking for a pic-a-nic basket?")

      case _ => println(s"Go away, $input! I'm looking for Yogi.\n")
