package romanNumbers

class RomanNumberManager {
    private val romanValues =
        RomanNumberEnum.entries
            .sortedByDescending { it.number }

    fun transformToRoman(number: Int): String {
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

    fun transformToDecimal(romanNumber: String): Int {
        var currentNum = 0
        var currentRomanNumber = romanNumber
        while (currentRomanNumber != "") {
            val newNumber = getOptimalRomanEnum(currentRomanNumber)
            currentRomanNumber = currentRomanNumber.removePrefix(newNumber.symbol)
            currentNum += newNumber.number
        }
        return currentNum
    }

    fun getOptimalRomanEnum(romanNumber: String): RomanNumberEnum {
        val twoChars = romanNumber.take(2)
        val oneChar = romanNumber.take(1)

        return romanValues.firstOrNull { it.symbol == twoChars }
            ?: romanValues.first { it.symbol == oneChar }
    }

    private fun getOptimalEnum(number: Int): RomanNumberEnum = romanValues.first { number >= it.number }

    private fun checkIfNumberCanBeTransformed(number: Int) {
        if (number !in 1..<4000) throw NumberFormatException()
    }
}
