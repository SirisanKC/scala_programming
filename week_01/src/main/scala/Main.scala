object CombinedDemo {
  def main(args: Array[String]): Unit = {

    // Task 1
    println("\n--- Task 1 ---")

    // below i created a mutable variable mutableVar  
    var mutableVar = "Hello"        
    println(s"Before mutation: $mutableVar")

    // as mutableVar is a mutable, here we assign new value "World" to it.
    mutableVar = "World"           
    println(s"After mutation: $mutableVar")

    // ImmutableVal is immutable variable, if we try to assign new value into it then it will throw Compilation error 
    val immutableVal = "Scala"     
    println(s"Immutable value: $immutableVal")

    /* As we mentioned in above line that, if we uncomment below line and try to run then 
      it will throw compilation error as val defines immutable variable*/

    // immutableVal = "Java"


    // Task 2
    println("\n--- Task 2 ---")

    /* 
    below i created 4 immutable variables and assigned value of different data into each 
    and printed that 
     */
    val isScalaAwesome = true      // Boolean inferred
    val piValue = 3.14159          // Double inferred
    val number = 42                // Int inferred
    val greeting = "Hello, Scala!" // String inferred

    println(s"isScalaAwesome (Boolean): $isScalaAwesome")
    println(s"piValue (Double): $piValue")
    println(s"number (Int): $number")
    println(s"greeting (String): $greeting")


    // Task 3
    println("\n--- Task 3 ---")

    /* Here below we defined two immutable variable c1 and c2 
       both c1 and c2 have datatype character    
    */
    val c1: Char = 'K'
    val c2: Char = 'C'

    // Here we Combine characters to form a string and then printing it
    val lastName = s"$c1$c2" 
    println(s"My last name is: $lastName")


    // Task 4
    println("\n--- Task 4 ---")

    /*Here I created a immutable variable age and assign value of my age into it
      and then printing it as given in exercise
    */
    val age = 21 
    println(s"I am learning Scala at the age of $age years.")


    // Task 5
    println("\n---Task 5 ---")

    /* An expression is a combination of operators and operands
       that is interpreted to produce some other value 
       below val result defines the immutable variable "result" and
       assigns the value of expression 5 + 3 
       expression is evaluted and result is assigned to result and 
       we printed that
    */
    val result = 5 + 3  
    println(s"Expression Example: 5 + 3 = $result") 


    // Task 6
    println("\n--- Task 6 ---")

    /* 
    Below we declared immutable variable 'score' and using if condition we try to
    find the grade.
    
    again we created a immutable variable grade which takes the value of variable score and compares 
    that using if condion and prints value based on result
    for example 85 is greater than 80 and smaller than 90 so it retuns grade 9
    */
    val score = 85
    val grade = if (score >= 90) 10 
                else if (score >= 80) 9
                else if (score >= 70) 8
                else 7

    println(s"Score: $score, Grade: $grade")


    // Task 7
    println("\n--- Task 7 ---")

    /*
    Below I declared 3 immutable variables, firstName where i assigned my first name; lastName where I assigned my last name;
    and fullName where I did string concatenating and prints it 
    */

    val firstName = "Sirisan"
    val surName = "KC"
    val fullName = firstName + " " + surName
    
    println(s"My full name is: $fullName")


    // Task 8
    println("\n--- Task 8 ---")

    /* 
    below I defined a function 'sumToString' which takes a and b as two parameters of int data type,
    String is the return type of the function which returns the value that is calculated in ${a + b}
    and returns that and println prints the value returned by function sumToString using paramater 5 and 7 
    */
    def sumToString(a: Int, b: Int): String = {
      s"The sum of $a and $b is: ${a + b}"
    }

    println(sumToString(5, 7))

  }
}