package fizz.buzz

class FizzBuzz(var num: Int) {
    public fun getNumber(): Int {
        return num
    }

    public fun fizzBuzz(): String {
        return if (num % 3 == 0 && num % 5 == 0) "fizzbuzz"
        else if (num % 3 == 0) "fizz"
        else if (num % 5 == 0) "buzz"
        else "$num"
    }
}
