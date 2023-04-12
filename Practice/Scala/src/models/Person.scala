package io.beansprout
package models

val DEFAULT_AGE: Int = 18

class Person(var name: String, var age: Int):

  override def toString: String =
    s"""{
       |"name":"$name",
       |"age":$age
       |}""".stripMargin

object Person:
  def apply(name: String): Person =
    new Person(name, DEFAULT_AGE)

  def apply(name: String, age: Int): Person =
    new Person(name, age)

