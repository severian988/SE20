import java.math.BigInteger

fun isPrime(x:BigInteger): Boolean{
    // 1 is not Prime
    if (x==1.toBigInteger()) return false
    // 2 and 3 are Prime
    if (x==2.toBigInteger() || x==3.toBigInteger()) return true

    // Checking if x is a multiple of 2 or 3  -> not Prime
    if (x % 2.toBigInteger() == 0.toBigInteger() || x % 2.toBigInteger() == 0.toBigInteger()) return false

    // Beginning the loop at 5
    var i = 5.toBigInteger()
    while( i <= x.sqrt() ){
        if (x % i == 0.toBigInteger() || x % (i+2.toBigInteger()) == 0.toBigInteger()) return false
        i += 6.toBigInteger()
    }
    return true
}
fun main() {
    for (i in 1..20) {
        var n = ((10.toBigDecimal().pow(i)-1.toBigDecimal()) / 9.toBigDecimal()).toBigInteger()
        println("R%d - %d %b".format(i, n, isPrime(n)))
    }
}
