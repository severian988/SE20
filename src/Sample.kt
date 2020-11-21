import kotlin.math.*
import java.math.BigInteger

fun isPrime(x:BigInteger): Boolean{
    if (x==2.toBigInteger() || x==3.toBigInteger()) return true
    if(x==1.toBigInteger() || x%2.toBigInteger()==0.toBigInteger() || x%3.toBigInteger()==0.toBigInteger()) return false
    var j = 5.toBigInteger()
    while (j < x.sqrt()) {
        if (x % j == 0.toBigInteger() || x % (j+2.toBigInteger()) == 0.toBigInteger()) {
            return false
        }
        j+=6.toBigInteger()
    }
    return true
}
fun main() {
    for (i in 1..20) {
        var n = ((10.toBigDecimal().pow(i)) / 9.toBigDecimal()).toBigInteger()
        if (isPrime(i.toBigInteger())){
            println("R = %d : %d %b".format(i, n, isPrime(n)))
        }
        else{
            println("R = %d : %d %b".format(i, n, false))
        }

    }
}
