package fizz.buzz

import fizz.buzz.FizzBuzz
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun returnNum(){
        var fizzbuzz = FizzBuzz(6)
        assertEquals(6, fizzbuzz.getNumber())
    }

    @Test
    fun `Devolver fizz`() {
        var multiplo_3 = 6
        var fizzbuzz = FizzBuzz(multiplo_3)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("fizz", result)
    }

    @Test
    fun `Devolver buzz`() {
        var multiplo_5 = 10
        var fizzbuzz = FizzBuzz(multiplo_5)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("buzz", result)
    }

    @Test
    fun `Devolver fizzbuzz`() {
        var multiplo_3_y_5 = 15
        var fizzbuzz = FizzBuzz(multiplo_3_y_5)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("fizzbuzz", result)
    }
}