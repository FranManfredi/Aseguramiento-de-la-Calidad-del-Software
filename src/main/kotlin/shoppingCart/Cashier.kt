package shoppingCart

class Cashier {
    private val catalog: Catalog

    fun getCatalog(): Catalog = catalog

    fun checkout(
        cart: Cart,
        payment: PayForm,
    ) {
        val cartAmount = giveCartAmount(cart)
        if (canPay(cartAmount, payment)) {
            pay(cartAmount, payment)
            cart.removeAllFromCart()
        } else {
            throw IllegalArgumentException()
        }
    }

    private fun giveCartAmount(cart: Cart): Double {
        var totalAmount = 0.0
        for (cartItem in cart.getProducts()) {
            val entree = catalog.showEntrees().find { it.product == cartItem }

            if (entree != null) {
                totalAmount += entree.price.getValue()
            } else {
                throw IllegalArgumentException()
            }
        }
        return totalAmount
    }

    private fun pay(
        amount: Double,
        payment: PayForm,
    ) {
        if (payment is Cash) {
            val currentAmount = payment.getAmount()
            payment.setAmount(Dollar(currentAmount - amount))
        }
    }

    private fun canPay(
        amount: Double,
        payment: PayForm,
    ): Boolean {
        if (payment.getAmount() > amount) {
            return true
        }
        return false
    }

    constructor(catalog: Catalog) {
        this.catalog = catalog
    }
}
