// import kotlin.math.*
import java.math.BigInteger

fun isPrime(x:BigInteger): Boolean{
    if(x==1.toBigInteger()) return false
    if(x==2.toBigInteger()) return true
    if(x % 2.toBigInteger() == 0.toBigInteger()) return false
    for (i in 3L..x.sqrt().toLong() step 2L){
        if(x % i.toBigInteger() == 0.toBigInteger()){
            return false
        }
    }
    return true
}
fun main() {
    var n = BigInteger.ONE
    val checker = Checker()
    for (i in 1L..400L) {
        var ans = checker.isRepunitPrime(i,n)
        println("R_%d %b".format(i,ans) )
        n = n * BigInteger.valueOf(10) + BigInteger.ONE
    }
}
