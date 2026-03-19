package romanNumbers

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
    fun throwErrorIfDecimalNumberIsNegative() {
        assertThrows(Exception::class.java) { rnm.transformToRoman(-10) }
    }

    @Test
    fun transformSimpleDecimalNumber() {
        val result = rnm.transformToRoman(10)
        assertEquals("X", result)
    }

    @Test
    fun transformComplexDecimalNumber() {
        val result = rnm.transformToRoman(944)
        assertEquals("CMXLIV", result)
    }

    @Test
    fun limitRomanNumbersTo3999() {
        assertThrows(Exception::class.java) { rnm.transformToRoman(4000) }
    }

    @Test
    fun throwErrorIfDecimalNumberIsZero() {
        assertThrows(Exception::class.java) { rnm.transformToRoman(0) }
    }

    @Test
    fun transformSimpleRomanNumber() {
        val result = rnm.getOptimalRomanEnum("IX").number
        assertEquals(9, result)
    }

    @Test
    fun transformComplexRomanNumber() {
        val result = rnm.transformToDecimal("CMXLIV")
        assertEquals(944, result)
    }
}
