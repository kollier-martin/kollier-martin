# Scala 3 Notes

## Function Definition

You can define the main function with an annotation in Scala 3.

```Scala
@main
def main(): Unit = 
    println("Hello World!")

```

opposed to the old way ->

```Scala
object hello {
  def main(args: Array[String]) = 
    println("Hello, World!")
}
```

Declaring other functions is also easy to do.

```Scala
def helloWorld(): Unit = 
  println("Hello World!")
```

## Variable Declaration

The keyword ``val`` is used to declare an immutable (not changeable during runtime) variable       
The keyword ``var`` is used to declare a mutable (changeable during runtime) variable

You can specify the data type of the variable by adding the type during variable creation.

```Scala
val asterisk = "*"
// or explicitly, val asterisk:String = "*"
asterisk = "**" //Fails because this variable is immutable

var asterisks = "*"
// or explicitly, or var asterisk:String = "*"
asterisks = "**" //Compiles since it is mutable
```

## Data Types

Scala does not have primitive types, everything is an object

```Scala
val b: Byte = 1
val i: Int = 1
val l: Long = 1 // val l = 1L
val s: Short = 1
val d: Double = 1.0 // val d = 1.0D
val f: Float = 1.0 // val f = 1.0F
var a = BigInt(1_234_567_890_987_654_321L)
var b = BigDecimal(123_456.789)
var string = "String"
var char = 'c'
```

## String Interpolation

Evaluates a literal string that contains placeholders.

**s** is only one option to string interpolation. It allows the usage of variables in a string.        
**f** is type safe and equivalent to the *printf* function in Java.     
**raw** does not allow the escaping of literals, but works similar to the **s** interpolator.

To embed expressions inside a string, enclose them in curly braces

```Scala
val firstName = "Kollier"
val lastName = "Martin"

println(s"Name: $firstName $lastName - Age: ${10 + 14}")
println(f"Name: $firstName%s $lastName%s - Age: ${10 + 14}%d")
println(raw"Name: $firstName%s $lastName%s \n")
```

## Control Constructs

#### if / if-else

- In Scala 3, formatting if statements does not have to follow Java-esque standards
```Scala
// Example: An overloaded compare functions
def divide(a: Int, b: Int): Any =
  if a == 0 || b == 0 then
    println("You can not divide by zero.")
  else
    a / b
```

- All if / if-else statements return a value
```Scala
// Example: An overloaded compare functions
def compare(a: Int, b: Int): Int =
  if a < b then
    -1
  else if a == b then
    0
  else
    1
```

#### *for* expressions

- Uses something called a generator '<-'. In my terms the generator iterates over a range or values in a collection and
  then assigns the value to "i" during execution of the loop. This replaces the need for Java standards *for (int i = 0;
  i < ints.length; i++)...* (This is my assumption without looking at the literal definition)
    - Example:
      ```Scala
      val ints = List(1, 2, 3, 4, 5)
      
      for i <- 0 to 4 do println(i)
      for i <- ints do println(i)
      ```
- Uses ***guards***, these are just multiple if statements within one for loop. There can be multiple generators and
  multiple guard, the conditions have to be met for the ***do*** to execute
    - Example 1:
      ```Scala
      for
        i <- ints
        if i > 2
      do
        println(i)
      ```
    - Example 2:
      ```Scala
      for
        i <- 1 to 3
        j <- 'a' to 'c'
        if i == 2
        if j == 'b'
      do
        println(s"i = $i, j = $j")   // prints: "i = 2, j = b"
      ```
- There are ***for expressions*** that can use the ***yield*** keyword instead of the ***do*** keyword to calculate and yield results.
    - Example:
      ```Scala
      val doubleInts = for i <- ints yield i * 2
      // this should produce a new list: List[Int] = List(2, 4, 6, 8, 10)
      ```
- Maps can also be used with for loops (of course)
    - Example:
  ```Scala
  val countriesWithCodes = Map(
    "Afghanistan" -> "AF",
    "Albania" -> "AL"
  )
  
  for (country, isoTwo) <- countriesWithCodes do println(s"$isoTwo: $isoThree") // Can be typed in the REPL
  ```
  
#### Match Expressions

- ***match*** statements exist and are used like Java switch statements
    - Example:
  ```Scala
  print("Input 'Y' or 'N': ")
  val input = readLine()
  
  input match 
    case "Y" => println("Yes has been received as input.")
    case "N" => println("No has been received as input.")
  ```