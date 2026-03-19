package shoppingCart

class Product {
    val name: String
    val description: String
    val price: Dollar

    fun checkPrice(): Double = price.getValue()

    constructor(name: String, description: String) {
        this.name = name
        this.description = description
        this.price = Dollar(0.0)
    }

    constructor(name: String, description: String, price: Dollar) {
        this.name = name
        this.description = description
        this.price = price
    }
}
