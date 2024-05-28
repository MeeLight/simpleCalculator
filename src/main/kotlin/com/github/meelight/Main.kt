package com.github.meelight

// Utilities
fun doubleToString(value: Double): String {
  return value.toBigDecimal().toPlainString()
}

fun getStrIntValue(value: String): String {
  if (value.indexOf(".") != -1) {
    return value.substring(0, value.indexOf("."))
  }

  return value
}

fun getStrDecimalPart(value: String): String {
  if (value.indexOf(".") != -1) {
    return value.substring((value.indexOf(".") + 1), value.length)
  }

  return ""
}

fun getStrNumberValue(
  strNumber: String,
  intPart: String,
  decimalPart: String
): String {
  when (decimalPart.length) {
    0 -> return getStrIntValue(strNumber)
    1 -> {
      return if (decimalPart == "0") intPart
      else "${intPart}.${decimalPart}"
    }
    2 -> return "${intPart}.${decimalPart.substring(0, 2)}"
    3 -> return "${intPart}.${decimalPart.substring(0, 3)}"
    4 -> return "${intPart}.${decimalPart.substring(0, 4)}"
    5 -> return "${intPart}.${decimalPart.substring(0, 5)}"
    6 -> return "${intPart}.${decimalPart.substring(0, 6)}"
    7 -> return "${intPart}.${decimalPart.substring(0, 7)}"
    8 -> return "${intPart}.${decimalPart.substring(0, 8)}"
    9 -> return "${intPart}.${decimalPart.substring(0, 9)}"
    10 -> return "${intPart}.${decimalPart.substring(0, 10)}"
  }

  return ""
}

fun getStrFixedDecimal(value: String): String {
  val intPart: String = getStrIntValue(value)
  val decimalPart: String = getStrDecimalPart(value)

  if (decimalPart.length > 10) return "${intPart}.${decimalPart.substring(0, 4)}"
  return getStrNumberValue(value, intPart, decimalPart)
}

// Classes
public class SimpleCalculator(val x: Double, val y: Double) {
  var firstNumber: Double
  var secondNumber: Double

  init {
    firstNumber = x
    secondNumber = y
  }

  fun getAdd(): Double {
    return firstNumber + secondNumber
  }

  fun getSubtract(): Double {
    return firstNumber - secondNumber
  }

  fun getMultiply(): Double {
    return firstNumber * secondNumber
  }

  fun getDivide(): Double {
    if (secondNumber != 0.0) return firstNumber / secondNumber
    return -1.0
  }

  fun getMessageOfTheOperation(separator: String): String {
    val fNumber: String = doubleToString(firstNumber)
    val sNumber: String = doubleToString(secondNumber)

    return "${getStrFixedDecimal(fNumber)} $separator ${getStrFixedDecimal(sNumber)} ="
  }
}

fun main() {
  val calc = SimpleCalculator(25.0, 0.2)
  val addResult: String = doubleToString(calc.getAdd())
  val subtractResult: String = doubleToString(calc.getSubtract())
  val multiplyResult: String = doubleToString(calc.getMultiply())
  val divideResult: String = doubleToString(calc.getDivide())

  println("Simple Calculator - Kotlin CLI | github.com/MeeLight\n")
  println("${calc.getMessageOfTheOperation("+")} ${getStrFixedDecimal(addResult)}")
  println("${calc.getMessageOfTheOperation("-")} ${getStrFixedDecimal(subtractResult)}")
  println("${calc.getMessageOfTheOperation("x")} ${getStrFixedDecimal(multiplyResult)}")

  if (calc.secondNumber == 0.0) {
    println("Oops! You can't divide by zero.")
  } else {
    println("${calc.getMessageOfTheOperation("/")} ${getStrFixedDecimal(divideResult)}")
  }
}
