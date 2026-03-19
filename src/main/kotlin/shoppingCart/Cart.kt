package shoppingCart

class Cart {
    val cart = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun removeFromCart(product: Product) {
        if (isEmpty()) {
            throw IllegalStateException("Cart is empty")
        }
        cart.remove(product)
    }

    fun isEmpty(): Boolean = cart.isEmpty()
}
