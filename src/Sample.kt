import kotlin.math.*

fun Fermat(x:Double): Boolean{
    if(x==1.0) {
        return false
    }
    var n = 0
    val y = 2


        if(2.0.pow((x-1).toDouble()) % x == 1.0) {
            return true
        }
    return false
}

fun isPrime(x:Long): Boolean {
    if (x == 1L) return false

    for (j in 2L..(sqrt(x.toDouble())).toLong()) {
        if (x % j == 0L) {
            return false
        }
    }
    return true
}

fun main() {
    var n = 0L
    for(i in 1..19){
        n = n * 10L + 1L
        println("%d %d %b".format(i, n, Fermat(n.toDouble())))
    }
    n = 0L
    for(i in 1..19){
        n = n * 10L + 1L
        println("%d %d %b".format(i, n, isPrime(n)))
    }
}