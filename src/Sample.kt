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
    var nMinusOne = 0.toBigInteger()
    for (i in 1L..22L) {
        val n = nMinusOne + 1.toBigInteger()
        var ans = false
        if( isPrime(n.toString().length.toBigInteger()) ){
            ans = isPrime(n)
        }
        println("%d %b".format(n,ans) )
        nMinusOne = n * 10.toBigInteger()
    }
}
