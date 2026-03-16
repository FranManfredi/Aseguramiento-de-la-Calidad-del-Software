package fizz.buzz

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    @Test
    fun returnNum() {
        var fizzbuzz = FizzBuzz(6)
        assertEquals(6, fizzbuzz.getNumber())
    }

    @Test
    fun `Devolver fizz`() {
        var multiplo3 = 6
        var fizzbuzz = FizzBuzz(multiplo3)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("fizz", result)
    }

    @Test
    fun `Devolver buzz`() {
        var multiplo5 = 10
        var fizzbuzz = FizzBuzz(multiplo5)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("buzz", result)
    }

    @Test
    fun `Devolver fizzbuzz`() {
        var multiplo3y5 = 15
        var fizzbuzz = FizzBuzz(multiplo3y5)
        var result = fizzbuzz.fizzBuzz()

        assertEquals("fizzbuzz", result)
    }
}
