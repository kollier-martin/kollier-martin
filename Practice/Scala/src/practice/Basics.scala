package io.beansprout
package practice

import scala.io.StdIn.readLine

class Basics {
  /**
   * Runs hello world
   */
  def helloWorld(): Unit = {
    println("Hello World!")
  }
  
  /**
   * Runs hello user
   */
  def helloUser(): Unit = {
    print("Please enter your name: ")
    val name = readLine()
  
    println("Hello, " + name + "!")
  }

  /**
   * Runs string interpolation example
   */
  def sInterpolation(): Unit = {
    val firstName = "Kollier"
    val lastName = "Martin"
  
    println(f"Name: $firstName%s $lastName%s - Age: ${10 + 14}%d")
    println(raw"Name: $firstName $lastName %s \n")
    println(s"Name: $firstName $lastName - Age: ${10 + 14}\n")
  }

  /**
   * Executes multiline blocks
   */
  def multiLineBlocks(): Unit = {
    println(
      s"""I am learning Scala and documenting everything as I go.
         |I am enjoying this new experience.
         |I can not wait to combine everything into an application.\n""".stripMargin)
  }
}
