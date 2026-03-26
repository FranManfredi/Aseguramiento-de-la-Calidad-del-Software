package shoppingCart

class Cash : PayForm {
    private var amount: Dollar

    constructor(amount: Dollar) {
        this.amount = amount
    }

    override fun getAmount(): Double = amount.getValue()

    override fun setAmount(amount: Dollar) {
        this.amount = amount
    }
}
