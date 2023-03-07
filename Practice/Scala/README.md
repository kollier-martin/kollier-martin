# Scala Notes

## Function Definition
You can define the main function with an annotation in Scala 3.
```Scala
@main
def main(): Unit = {
    println("Hello World!")
}
```

opposed to the old way ->

```Scala
object hello {
  def main(args: Array[String]) = {
    println("Hello, World!")
  }
}
```

Declaring other functions is also easy to do.
```Scala
def helloWorld(): Unit = {
  println("Hello World!")
}
```

## Variable Declaration
The keyword ``val`` is used to declare an immutable (not changeable during runtime) variable       
The keyword ``var`` is used to declare a mutable (changeable during runtime) variable

You can specify the data type of the variable by adding the type during variable creation.
```Scala
val asterisk = "*" 
// or val asterisk:String = "*"
asterisk = "**" //Fails because this variable is immutable

var asterisk = "*" 
// or var asterisk:String = "*"
asterisk = "**" //Compiles since it is mutable
```