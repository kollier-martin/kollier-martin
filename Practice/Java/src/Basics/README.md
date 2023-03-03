# Custom Functional Interface

______________________________
***String Formatter***
----------------------
This interface allows the creation of custom formats

Abstract Method: String format(String string1, String string2)

Example: [String Formatter](StringFormatter.java)

# DateTime

______________________________
API consisting of functionalities to display date and time  
LocalTime is mutable, while LocalDateTime and LocalDate are not

Example: [DateTime](DateTime.java)

# Streams

______________________________
Streams initiate functions on a collection, it is not a collection  
Intermediate - returns another stream and can be chained together  
Terminal - produces a result from the pipeline

Example: [Streams](Streams.java)  
Reference: [Terminal Operations](https://www.codejava.net/java-core/collections/java-8-stream-terminal-operations-examples)
, [Intermediate Operations](https://www.javacodegeeks.com/2020/04/java-8-stream-intermediate-operations-methods-examples.html)

# Functional Packages

______________________________
Code: [Functions](Functions.java)

***Function***
----------------------
Function that accepts a single argument and produces a result

Abstract Method: R apply(T t)

***Predicate***
----------------------
Boolean-valued function that takes a single argument

Abstract Method: boolean test(T t)

***Consumer***
----------------------
Function that accepts a single argument but returns no result

Abstract Method: void accept(T t)

***Supplier***
----------------------
A function that denotes a supplier of results

Abstract Method: T get()  