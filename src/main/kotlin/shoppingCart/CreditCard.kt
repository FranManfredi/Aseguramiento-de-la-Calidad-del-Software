package shoppingCart

class CreditCard : PayForm {
    var credited: Dollar
    val cap: Dollar

    constructor(credited: Dollar, cap: Dollar) {
        this.credited = credited
        this.cap = cap
    }

    override fun getAmount(): Double = cap.getValue() - credited.getValue()

    override fun setAmount(amount: Dollar) {
        this.credited = amount
    }
}
