package io.beansprout
package Practice

import scala.io.StdIn.readLine

@main
def main(): Unit = {
  helloWorld()
  helloUser()
  sInterpolation()
  multiLineBlocks()
}

private def helloWorld(): Unit = {
  println("Hello World!")
}

private def helloUser(): Unit = {
  print("Please enter your name: ")
  val name = readLine()

  println("Hello, " + name + "!")
}

private def sInterpolation(): Unit = {
  val firstName = "Kollier"
  val lastName = "Martin"

  println(f"Name: $firstName%s $lastName%s - Age: ${10 + 14}%d")
  println(raw"Name: $firstName%s $lastName%s \n")
  println(s"Name: $firstName $lastName - Age: ${10 + 14}\n")
}

private def multiLineBlocks(): Unit = {
  println(
    s"""I am learning Scala and documenting everything as I go.
       |I am enjoying this new experience.
       |I can not wait to combine everything into an application.\n""".stripMargin)
}
