package io.beansprout
package Practice

import scala.io.StdIn.readLine

@main
def main(): Unit = {
  helloWorld()
  helloUser()
}

def helloWorld(): Unit = {
  println("Hello World!")
}

def helloUser(): Unit = {
  print("Please enter your name: ")
  val name = readLine()

  println("Hello, " + name + "!")
}