package RomanNumbers

class RomanNumberManager {
    private val romanValues =
        RomanNumberEnum.entries
            .sortedByDescending { it.number }

    fun transform(number: Int): String {
        checkIfNumberCanBeTransformed(number)
        var currentNum = number
        var romanNumber = ""
        while (currentNum != 0) {
            val newSymbol = getOptimalEnum(currentNum)
            currentNum -= newSymbol.number
            romanNumber += newSymbol.symbol
        }
        return romanNumber
    }

    private fun getOptimalEnum(number: Int): RomanNumberEnum = romanValues.first { number >= it.number }

    private fun checkIfNumberCanBeTransformed(number: Int) {
        if (number !in 1..<4000) throw NumberFormatException()
    }
}
