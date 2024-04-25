package org.jetbrains.scala
import scala.util.Random



object LetsPlay {
  def main(args: Array[String]): Unit = {
    //Ask for a string
    println("Please enter a string: ")
    //Input String from user
    val inputString = scala.io.StdIn.readLine()

    //Count the number of characters
    val characterCount = countCharacters(inputString)

    //Check if there are an even number of vowels
    val evenVowels = hasEvenNumberOfVowels(inputString)

    //Oh No! There's a weird print!

    //Print the result
    println(s"The number of characters in the string '$inputString' is: $characterCount")
    println(s"The string '$inputString' has a even number of vowels: $evenVowels")

    //Oh No! There's a weird print!
    println("I don't feel too well...")
    brokenStringGlitch(inputString)
  }
  //declared after main: not a static scope program; its dynamic scope
  def countCharacters(input: String): Int = {
    //Base case: If the input String is empty, return 0
    if(input.isEmpty){
      0
    }
    else{
      //Recursive Case: Count the characters in the substring starting from index
      //and add 1 for the first character
      1 + countCharacters(input.substring(1))
    }
  }
  /*
  STL will allow shorter non recursive function. (Faster!)
  def countCharacter(input: String): Int = {
    input.length
  }
   */

  def hasEvenNumberOfVowels(input: String): Boolean = {
    //Define a set of Vowels
    val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    //Initialize variable to count vowels
    var vowelCount = 0

    //Iterate through each character in the input string
    for(char <- input){
      //Check if the character is a vowel
      if(vowels.contains(char)) {
        vowelCount += 1
      }
    }

    //Count the number of vowels in the input string
    //val vowelCount = input.count(vowels.contains)

    //check if the count is even
    vowelCount % 2 == 0
  }

  def brokenStringGlitch(input: String): Unit = {
    val size = input.length
    val random = new scala.util.Random

    for(i <- 0 until 5) {
      //Generate a random number within the length of the string
      val randomNumber = random.nextInt(size)
      val char = input.substring(randomNumber, randomNumber + 1)

      if(randomNumber % 2 == 0) {
        print(char.toUpperCase())
      }
      else {print(char)}
    }
  }
}
