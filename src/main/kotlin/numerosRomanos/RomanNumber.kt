package numerosRomanos

class RomanNumber(
    private val value: RomanNumberEnum,
) {
    fun getValue(): String = value.symbol
}
