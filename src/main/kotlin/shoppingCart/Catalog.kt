package shoppingCart

class Catalog(
    private val products: List<Entree>,
) {
    init {
        val productSet = mutableSetOf<Product>()
        products.forEach {
            if (!productSet.add(it.product)) {
                throw IllegalArgumentException()
            }
        }
    }

    fun showEntrees(): List<Entree> = products
}
