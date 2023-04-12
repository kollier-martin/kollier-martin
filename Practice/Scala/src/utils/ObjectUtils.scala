package io.beansprout
package utils

import scala.collection.mutable.ArrayBuffer

object ObjectUtils {
  /**
   * This method is used to retrieve all methods
   * @param obj object to retrieve methods from
   * @param availableMethods methods that have been
   * @return comma delimited list containing all declared methods
   */
  def retrieveDeclaredMethods(obj: Object, availableMethods: ArrayBuffer[String]): Array[availableMethods.type] =
    obj
      .getClass
      .getDeclaredMethods
      .map(_.getName)
      .filter(!_.contains("$"))
      .sorted
      .collect(availableMethods += _)
}
