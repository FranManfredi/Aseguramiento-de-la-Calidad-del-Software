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
            Catalog(entrees)
        }
    }

    @Test
    fun `test012 - cashier must exist`() {
        val entrees =
            listOf<Entree>(
                Entree(Product("pepsi", "de 2 lt"), Dollar(2.00)),
                Entree(Product("coca cola", "de 2 lt"), Dollar(3.50)),
            )
        val cashier = Cashier(Catalog(entrees))
        assertNotNull(cashier.getCatalog())
    }

    @Test
    fun `test013 - payment options must exist`() {
        assertNotNull(DebitCard(Dollar(100.00)))
        assertNotNull(CreditCard(Dollar(100.00), Dollar(200.00)))
        assertNotNull(Cash(Dollar(100.00)))
    }

    @Test
    fun `test013 - checkout of cart with cash`() {
        val cart = Cart()
        val product1 = Product("papas fritas", "papas fritas marca Peguamar")
        val product2 = Product("cocacola", "botella de 2.5 litros")
        val listOfProducts = listOf(product1, product2, product2, product1)
        cart.addToCart(listOfProducts)
        val entrees =
            listOf<Entree>(
                Entree(product1, Dollar(2.00)),
                Entree(product2, Dollar(3.50)),
            )
        val cashier = Cashier(Catalog(entrees))
        val cash = Cash(Dollar(20.00))
        cashier.checkout(cart, cash)
        assertEquals(9.00, cash.getAmount())
        assertEquals(true, cart.isEmpty())
    }

    @Test
    fun `test014 - throw error if product is in cart but not in catalog`() {
        val cart = Cart()
        val product1 = Product("papas fritas", "papas fritas marca Peguamar")
        val product2 = Product("cocacola", "botella de 2.5 litros")
        val listOfProducts = listOf(product1, product2, product2, product1)
        cart.addToCart(listOfProducts)
        val entrees =
            listOf<Entree>(
                Entree(product1, Dollar(2.00)),
            )
        val cashier = Cashier(Catalog(entrees))
        val cash = Cash(Dollar(20.00))
        assertThrows(IllegalArgumentException::class.java) {
            cashier.checkout(cart, cash)
        }
    }

    //  TODO:
    //     hacer el cajero
    //          implementar los metodos tradicionales de credito y debito (hacer bien inyeccion de dependencia)
    //     ofertas, promos y descuentos
    //     TRUEQUE al pagar con el cajero
}
