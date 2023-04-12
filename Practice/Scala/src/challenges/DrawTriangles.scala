package io.beansprout
package challenges

class DrawTriangles {
  /**
   * Draw triangles with a specified number of rows
   * @param rowOfStars how many rows to draw into the triangle
   */
  def makeTriangles(rowOfStars: Int): Unit =
    val aster = "*"

    for (_ <- 1 to 3) do //starts next triangle
      var t = 1

      for (_ <- 1 to rowOfStars) do //creates a new line
        for (_ <- 1 to t) do //loops asterisks
          print(aster)

        println()
        t += 2

    println()
}
