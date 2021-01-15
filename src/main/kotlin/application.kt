package main.kotlin

import main.kotlin.domain.user.User

fun main() {
    val x: Double = 5.5
    val y: Double = 5.3
    print("$x + $y = ${String.format("%.2f", x+y)}")

    val user1 = User("Eduardo", "Jose")
    val user2 = User("Eduardo", "Jose")
    print("\n\n\n")
    println(user1 == user2)
    println(user1 === user2)

    val myString = "Eu gosto muito do StackOverFlow".also(::println)

    hasInitBlock("bilu bilu", null)
    hasInitBlock( boolean = true, name = "Baby Beef")

    val rafaela = User("Vaca", "Rafaela")
    val lastRafaela = rafaela.copy(lastName = "Guilherme").also(::print)
    println()

    println("Digite algo a baixo: ")
    val userInput = readLine()
    println("Huuum... você digitou $userInput")
}

class hasInitBlock(val name: String? = "nothing", val number: Int? = 5, val boolean: Boolean = false){

    init{
        println("Faz algo quando a classe é instanciada! $name, $number, $boolean")
    }
}
