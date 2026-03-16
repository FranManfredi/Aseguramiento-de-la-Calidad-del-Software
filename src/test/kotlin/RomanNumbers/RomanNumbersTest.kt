package RomanNumbers

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanNumbersTest {
    val rnm = RomanNumberManager()
    val romanNumberOne = RomanNumber(RomanNumberEnum.ONE)
    val romanNumberFive = RomanNumber(RomanNumberEnum.FIVE)
    val romanNumberTen = RomanNumber(RomanNumberEnum.TEN)
    val romanNumberFifty = RomanNumber(RomanNumberEnum.FIFTY)
    val romanNumberOneHundred = RomanNumber(RomanNumberEnum.ONE_HUNDRED)
    val romanNumberFiveHundred = RomanNumber(RomanNumberEnum.FIVE_HUNDRED)
    val romanNumberThousand = RomanNumber(RomanNumberEnum.THOUSAND)

    @Test
    fun getRomanNumberTest() {
        assertEquals("I", romanNumberOne.getValue())
        assertEquals("V", romanNumberFive.getValue())
        assertEquals("X", romanNumberTen.getValue())
        assertEquals("L", romanNumberFifty.getValue())
        assertEquals("C", romanNumberOneHundred.getValue())
        assertEquals("D", romanNumberFiveHundred.getValue())
        assertEquals("M", romanNumberThousand.getValue())
    }

    @Test
    fun throwErrorIfNumberIsNegative() {
        assertThrows(Exception::class.java) { rnm.transform(-10) }
    }

    @Test
    fun transformSimpleNumber() {
        val result = rnm.transform(10)
        assertEquals("X", result)
    }

    @Test
    fun transformComplexNumber() {
        val result = rnm.transform(944)
        assertEquals("CMXLIV", result)
    }

    @Test
    fun limitRomanNumbersTo3999() {
        assertThrows(Exception::class.java) { rnm.transform(4000) }
    }

    @Test
    fun throwErrorIfNumberIsZero() {
        assertThrows(Exception::class.java) { rnm.transform(0) }
    }
}
