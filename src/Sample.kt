import kotlin.math.*

fun isPrime(x:Long): Boolean{
    if(x==1L) return false
    if(x==2L) return true
    if(x%2L == 0L) return false

    for (j in 3L..sqrt(x.toDouble()).toInt()+1 step 2) {
    	if (x % j == 0L) return false
        
    }

    return true
}

fun main() {
    for (i in 1..19) {
        var n = "1".repeat(i).toLong()
        println("%d %b".format(n, isPrime(n)))
    }
}
