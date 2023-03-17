package io.beansprout
package models

class Person(name: String, age: Int) {
  def this(name: String) = {
    this(name, 0)
  }

  def getName: String = name

  def getAge: Int = age

  override def toString: String =
    s"""{
       |"name":"${name}",
       |"age":${age}
       |}""".stripMargin
}
