package fizz.buzz

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FizzBuzzTest {
    @Test
    fun returnNum() {
        val fizzbuzz = FizzBuzz(6)
        assertEquals(6, fizzbuzz.getNumber())
    }

    @Test
    fun returnFizz() {
        val multiplo3 = 6
        val fizzbuzz = FizzBuzz(multiplo3)
        val result = fizzbuzz.fizzBuzz()

        assertEquals("fizz", result)
    }

    @Test
    fun returnBuzz() {
        val multiplo5 = 10
        val fizzbuzz = FizzBuzz(multiplo5)
        val result = fizzbuzz.fizzBuzz()

        assertEquals("buzz", result)
    }

    @Test
    fun returnFizzBuzz() {
        val multiplo3y5 = 15
        val fizzbuzz = FizzBuzz(multiplo3y5)
        val result = fizzbuzz.fizzBuzz()

        assertEquals("fizzbuzz", result)
    }
}
