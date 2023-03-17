package io.beansprout
package CodingChallenges

@main
def main(): Unit = {
  val triangleFactory = new DrawTriangles
  triangleFactory.makeTriangles(6)
}

class DrawTriangles {
  def makeTriangles(numOfTriangles: Int): Unit = {
    val aster = "*"

    for (_ <- 1 to 3) { //starts next triangle
      var t = 1

      for (_ <- 1 to numOfTriangles) { //creates a new line
        for (_ <- 1 to t) { //loops asterisks
          print(aster)
        }

        println()
        t += 2
      }
    }
  }
}
