package numerosRomanos

enum class RomanNumberEnum(
    val number: Int,
    val symbol: String,
) {
    ONE(1, "I"),
    FIVE(5, "V"),
    TEN(10, "X"),
    FIFTY(50, "L"),
    ONE_HUNDRED(100, "C"),
    FIVE_HUNDRED(500, "D"),
    THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "CM"),
    FOUR_HUNDRED(400, "CD"),
    NINETY(90, "XC"),
    FORTY(40, "XL"),
    NINE(9, "IX"),
    FOUR(4, "IV"),
}
