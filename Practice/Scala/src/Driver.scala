package io.beansprout

import challenges.DrawTriangles
import constants.ErrorMessages.*
import constants.MethodConstants.*
import practice.{Basics, ControlStructures}
import utils.ObjectUtils

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.control.Breaks.*

class Driver {
  private val triangleFactory = new DrawTriangles
  private val basicFactory = new Basics
  private val controlStructures = new ControlStructures

  private val METHOD_LOOKUP: Map[Object, List[String]] =
    Map(
      triangleFactory -> List(MAKE_TRIANGLES),
      basicFactory -> List(HELLO_USER, HELLO_WORLD, S_INTERPOLATION, MULTILINE_BLOCKS),
      controlStructures -> List(IF_EXPR, FOR_LOOPS, MATCH_EXPR)
    )

  /**
   * Executes one specified function from the provided list
   */
  def executeOne(): Unit =
    val availableMethods = ArrayBuffer[String]()

    // for each object in the object list retrieve all of the method's names and add them to the list
    for obj <- METHOD_LOOKUP.keySet
      do ObjectUtils.retrieveDeclaredMethods(obj, availableMethods)

    println(s"List of available functions: ${availableMethods.mkString(", ")}")
    print("What process would you like to execute? (Case Sensitive): ")

    val input = readLine()

    breakable {
      for (obj, methods) <- METHOD_LOOKUP
        do
          if input == MAKE_TRIANGLES then
            triangleFactory.makeTriangles(6)
            break

          else if methods.contains(input) then
            try
              val clazz = obj.getClass
              clazz.getMethod(input).invoke(obj)
            catch
              case ex: IllegalAccessException => throw new Exception(FAILED_INVOCATION, ex)
    }

  /**
   * Executes all methods in the application
   */
  def doAll(): Unit =
    triangleFactory.makeTriangles(6)

    basicFactory.helloUser()
    basicFactory.helloWorld()
    basicFactory.sInterpolation()
    basicFactory.multiLineBlocks()

    controlStructures.runIfExpressions()
    controlStructures.runForLoops()
    controlStructures.runMatchExpressions()
}

@main
def main(): Unit = {
  val driver = new Driver

  print("Would you like to execute all functions? ")
  val input = readLine()

  input.toUpperCase() match
    case YES | Y => driver.doAll()

    case NO | N => driver.executeOne()

    case _ =>
      println("It seems that an unknown input was provided. Defaulting to executing all methods.")
      driver.doAll()
}
