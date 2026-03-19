package shoppingCart

class Dollar {
    private val value: Double

    fun getValue(): Double = value

    constructor(value: Double) {
        if (value < 0) throw IllegalArgumentException()
        this.value = value
    }
}
