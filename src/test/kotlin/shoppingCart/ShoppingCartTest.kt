package shoppingCart

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ShoppingCartTest {
    @Test
    fun `test001 - product must have name and description`() {
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        assertNotNull(product.name)
        assertNotNull(product.description)
    }

    @Test
    fun `test002 - shopping cart is empty`() {
        val cart = Cart()
        assertEquals(true, cart.isEmpty())
    }

    @Test
    fun `test003 - add product and cart is not empty`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        cart.addToCart(product)
        assertEquals(false, cart.isEmpty())
    }

    @Test
    fun `test004 - remove product and cart is empty again`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        cart.addToCart(product)
        assertEquals(false, cart.isEmpty())
        cart.removeFromCart(product)
        assertEquals(true, cart.isEmpty())
    }

    @Test
    fun `test005 - try remove product with empty cart`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        assertThrows<IllegalStateException> { cart.removeFromCart(product) }
    }

    //todo
    // agregar mas de un producto (simetria)
    // agregar dos productos iguales (simetria)
    // agreguen el precio
    // podemos arrancar a hacer el cajero
}
