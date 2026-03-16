package fizz.buzz

class FizzBuzz(
    var num: Int,
) {
    fun getNumber(): Int = num

    fun fizzBuzz(): String =
        if (num % 3 == 0 && num % 5 == 0) {
            "fizzbuzz"
        } else if (num % 3 == 0) {
            "fizz"
        } else if (num % 5 == 0) {
            "buzz"
        } else {
            "$num"
        }
}
