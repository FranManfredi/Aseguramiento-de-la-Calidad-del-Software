package shoppingCart

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
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
        cart.removeFromCart(product)
        assertEquals(true, cart.isEmpty())
    }

    @Test
    fun `test006 - add more than one product`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        val listOfProducts = listOf(product, product)
        cart.addToCart(listOfProducts)
        assertEquals(false, cart.isEmpty())
    }

    @Test
    fun `test007 - show how many products does cart have`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        val listOfProducts = listOf(product, product)
        cart.addToCart(listOfProducts)
        assertEquals(2, cart.getNumberOfProducts())
    }

    @Test
    fun `test008 - remove all products from cart`() {
        val cart = Cart()
        val product = Product("papas fritas", "papas fritas marca Peguamar")
        val listOfProducts = listOf(product, product)
        cart.addToCart(listOfProducts)
        cart.removeAllFromCart()
        assertEquals(true, cart.isEmpty())
    }

    @Test
    fun `test009 - remove all of single type product from cart`() {
        val cart = Cart()
        val product1 = Product("papas fritas", "papas fritas marca Peguamar")
        val product2 = Product("cocacola", "botella de 2.5 litros")
        val listOfProducts = listOf(product1, product1, product2, product1)
        cart.addToCart(listOfProducts)
        cart.removeAllFromCart(product1)
        assertEquals(1, cart.getNumberOfProducts())
    }

    @Test
    fun `test010 - create Catalog`() {
        val entrees =
            listOf<Entree>(
                Entree(Product("pepsi", "de 2 lt"), Dollar(2.0)),
            )
        val catalog = Catalog(entrees)
        assertEquals(entrees, catalog.showEntrees())
    }

    @Test
    fun `test011 - cannot have same product in catalog`() {
        assertThrows(IllegalArgumentException::class.java) {
            val entrees =
                listOf<Entree>(
                    Entree(Product("pepsi", "de 2 lt"), Dollar(2.00)),
                    Entree(Product("pepsi", "de 2 lt"), Dollar(3.50)),
                )
            val catalog = Catalog(entrees)
        }
    }

    //  TODO:
    //      podemos arrancar a hacer el cajero
}
