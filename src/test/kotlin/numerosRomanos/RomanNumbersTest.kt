package numerosRomanos

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanNumbersTest {
    val rnm = RomanNumberManager()
    val romanNumber_one = RomanNumber(RomanNumberEnum.ONE)
    val romanNumber_five = RomanNumber(RomanNumberEnum.FIVE)
    val romanNumber_ten = RomanNumber(RomanNumberEnum.TEN)
    val romanNumber_fifty = RomanNumber(RomanNumberEnum.FIFTY)
    val romanNumber_oneHundred = RomanNumber(RomanNumberEnum.ONE_HUNDRED)
    val romanNumber_fiveHundred = RomanNumber(RomanNumberEnum.FIVE_HUNDRED)
    val romanNumber_thousand = RomanNumber(RomanNumberEnum.THOUSAND)

    @Test
    fun getRomanNumberTest(){
        assertEquals("I", romanNumber_one.getValue())
        assertEquals("V", romanNumber_five.getValue())
        assertEquals("X", romanNumber_ten.getValue())
        assertEquals("L", romanNumber_fifty.getValue())
        assertEquals("C", romanNumber_oneHundred.getValue())
        assertEquals("D", romanNumber_fiveHundred.getValue())
        assertEquals("M", romanNumber_thousand.getValue())
    }

    @Test
    fun throwErrorIfNumberIsNegative(){
        assertThrows(Exception::class.java) { rnm.transform(-10) }
    }

    @Test
    fun transformSimpleNumber(){
        val result = rnm.transform(10)
        assertEquals("X", result)
    }

    @Test
    fun transformComplexNumber(){
        val result = rnm.transform(944)
        assertEquals("CMXLIV", result)
    }

    @Test
    fun limitRomanNumbersTo3999(){
        assertThrows(Exception::class.java) { rnm.transform(4000) }
    }

    @Test
    fun throwErrorIfNumberIsZero(){
        assertThrows(Exception::class.java) { rnm.transform(0) }
    }
}