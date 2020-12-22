package IncomeDataReader

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import scala.util.{Try, Success, Failure}

object IncomeDataReader extends App {
  val bufferedSource = io.Source.fromFile("adult.data")
  var rich = 0
  var poor = 0
  var count = 0
  var richMale = 0
  var richFemale = 0
  var poorMale = 0
  var poorFemale = 0

  var numMales = 0
  var numFemales = 0

  // val mongoClient = MongoClient("mongodb://mongo")
  // val database = mongoClient.getDatabase("Proj0DB")
  // val collection = database.createCollection("exampleCollectionName")

  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)

    //maybe i can use pattern matching here instead of if statements?
    // if (cols(14) == ">50K") rich += 1 else poor += 1
    // count += 1
    //printf("%s %s\n", cols(14), cols(9))

    //counting gender and income
    if (cols(14) == ">50K") {
      rich += 1
      if (cols(9) == "Female") {
        richFemale += 1
        numFemales += 1
      } else if (cols(9) == "Male") {
        richMale += 1
        numMales += 1
      } else {
        println("Error")
      }
    } else {
      poor += 1
      if (cols(9) == "Female") {
        poorFemale += 1
        numFemales += 1
      } else if (cols(9) == "Male") {
        poorMale += 1
        numMales += 1
      } else {
        println("Error")
      }
    }
    //counting
    count += 1

    //calculate average per category and compare duhhhhh

  }

  /** ******************************************
    * var validInput = false
    *  var userOption = "placeholderText"
    *  var validUserOption = 0
    *
    * //   def toInt(s: String): Int = {
    * //     try {
    * //       s = userOption.toInt
    * //     } catch {
    * //       case e: Exception => 0
    * //     }
    * //   }
    *
    *  def toInt(s: String): Option[Int] = {
    *    try {
    *      Some(s.toInt)
    *    } catch {
    *      case e: Exception => None
    *    }
    *  }
    *
    *  validUserOption = toInt(userOption)
    *
    *  while (!validInput) {
    *
    *    if (userOption == 1) validInput = true
    *    else if (userOption == 2) validInput = true
    *    else if (userOption == 3) validInput = true
    *    else if (userOption == 4) validInput = true
    *    else {
    *      println("Enter a valid integer (1 through 4)")
    *      validInput = false
    *    }
    *  }
    *
    *  userOption match {
    *    case 1 => println("Analyzing just race..")
    *    case 2 => println("Analyzing just gender..")
    *    case 3 => println("Analyzing race and gender..")
    *    case 4 => println("Adding data..")
    *    case _ => "invalid"
    *  }
    * *****************************************
    */
  println("Welcome to Wage Gap Analysis")
  println("loading...")
  println("Please select a option for analysis..")
  printf("1.Race\n2.Gender\n3.Race+Gender\n4.Add data\n")

  println(s"greater than 50k: $rich")
  println(s"less or equal to 50k: $poor")
  println(s"There are this many datasets: $count")
  println(s"There are this many Females: $numFemales")
  println(s"There are this many Males: $numMales")

  println(s"There are this many rich males: $richMale")
  println(s"There are this many rich females: $richFemale")
  println(s"There are this many poor males: $poorMale")
  println(s"There are this many poor females: $poorFemale")

  // println(("MyNameIsJohn").toList)

  // println(database.name)

  bufferedSource.close

}

//concurrency ideas - count each column at same time(?)
//out in crv format..or diff formats.
//options for diff types of anyalsis

//pseudo code
//get data
//break apart into different arrays(?) for each col
//analysis based on two columns picked
//ask about what data to enter
//log watever data is entered
