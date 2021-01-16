package calculator.main

import calculator.Calculator

fun main() {
    //Having fun
    fun printToMe(calculator: Calculator) = println().also { println(calculator.sum(5.0, 5.7, "3f")) }.also { println(calculator.sub(3.4, 9.2, "2f")) }.also { println(calculator.mul(2.3, 2.4, "5f")) }.also { println(calculator.div(1.5, 1.9, "6f")) }
    val calc = Calculator(withFrescurinha = true)
    printToMe(calc)

    calc.copy(withFrescurinha = false).also(::printToMe)

    CalculatorTwo()
}

//calc 2.0
open class CalculatorTwo {
    init {
        print("Say the first number: ")
        val x = readLine().orEmpty()
        print("Say the second number: ")
        val y = readLine().orEmpty()
        print("Say the operation (SUM, SUB, MUL, DIV): ")
        val operation: Operation = Operation.valueOf(readLine()?.toUpperCase().orEmpty())
        print(toEnum(x = x, y = y, format = "3f", operation = operation))
    }
}

enum class Operation { SUM, SUB, MUL, DIV }

//my imp 4 valueOf
fun toEnum(x: String, y: String, format: String = "2f", operation: Operation) = when (operation) {
    Operation.SUM -> "$x + $y = ${String.format("%.$format", (x.toDouble() + y.toDouble()))}"
    Operation.SUB -> "$x - $y = ${String.format("%.$format", (x.toDouble() - y.toDouble()))}"
    Operation.MUL -> "$x * $y = ${String.format("%.$format", (x.toDouble() * y.toDouble()))}"
    Operation.DIV -> "$x / $y = ${String.format("%.$format", (x.toDouble() / y.toDouble()))}"
}