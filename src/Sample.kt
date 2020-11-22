import java.math.BigInteger
import kotlin.math.*

fun isPrime(x:BigInteger): Boolean{
    if(x==1.toBigInteger()) return false
    if(x==2.toBigInteger()) return true
    if(x % 2.toBigInteger() == 0.toBigInteger()) return false
    var j = 3.toBigInteger()
    while( j <= x.sqrt() ){
        if (x % j == 0.toBigInteger() ) return false
        j += 2.toBigInteger()
    }
    return true
}

fun main() {
    var nMinusOne = 0.toBigInteger()
    for (i in 1L..20L) {
        val n = nMinusOne + 1.toBigInteger()
        println("%d %b".format(n, isPrime(n)))
        nMinusOne = n * 10.toBigInteger()
    }
}