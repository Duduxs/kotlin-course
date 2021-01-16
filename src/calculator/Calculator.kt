package calculator

data class Calculator(
        val withFrescurinha: Boolean = false
) {
    fun sum(
            x: Double,
            y: Double,
            formatter: String = "2f"
    ) = "${times("*")} $x + $y = ${String.format("%.$formatter", x + y)}"

    fun sub(
            x: Double,
            y: Double,
            formatter: String = "2f"
    ) = "${times("*")} $x - $y = ${String.format("%.$formatter", x - y)}"

    fun div(
            x: Double,
            y: Double,
            formatter: String = "2f"
    ) = "${times("*")} $x * $y = ${String.format("%.$formatter", x * y)}"

    fun mul(
            x: Double,
            y: Double,
            formatter: String = "2f"
    ) = "${times("*")} $x / $y = ${String.format("%.$formatter", x / y)}"

    init{
        println("\nVocê acabou de instanciar a classe Calculator!")
    }
}

fun Calculator.times(element: String, times: Int = 120) = if (withFrescurinha) element.repeat(times).plus("\n") else ""