import java.math.BigInteger

fun isPrime(x:BigInteger): Boolean{
    // 1 is not Prime
    if (x==1.toBigInteger()) return false
    // 2 and 3 are Prime
    if (x==2.toBigInteger() || x==3.toBigInteger()) return true

    // Checking if x is a multiple of 2 or 3  -> not Prime
    if (x % 2.toBigInteger() == 0.toBigInteger() || x % 3.toBigInteger() == 0.toBigInteger()) return false

    // Beginning the loop at 5
    var i = 5.toBigInteger()
    while( i <= x.sqrt() ){
        if (x % i == 0.toBigInteger() || x % (i+2.toBigInteger()) == 0.toBigInteger()) return false
        i += 6.toBigInteger()
    }
    return true
}
fun main() {
    // Printing the Rn from 1 to 20 with if it is prime or not
    for (n in 1..20) {
        var r = ((10.toBigDecimal().pow(n)) / 9.toBigDecimal()).toBigInteger()
        if (isPrime(n.toBigInteger())) {
            println("R%d - %d %b".format(n, r, isPrime(r)))
        } else{
            println("R%d - %d %s".format(n, r, "false"))
        }
    }
}
