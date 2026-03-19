package shoppingCart

class Cart {
    private val cart = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun addToCart(product: List<Product>) {
        cart.addAll(product)
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    fun removeAllFromCart() {
        cart.clear()
    }

    fun removeAllFromCart(product: Product) {
        cart.removeAll{ it == product }
    }

    fun isEmpty(): Boolean = cart.isEmpty()

    fun getNumberOfProducts(): Int = cart.size
}
