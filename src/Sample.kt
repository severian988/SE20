import kotlin.math.*

fun isPrime(x:Long): Boolean{
    if (x == 1L) return false
    else if (x == 2L) return true
    else if (x / 2L == 0L) return false

    var j = 3L
    while (j <= sqrt(x.toDouble())) {
        if (x % j == 0L) {
            return false
        }
        j += 2L
    }
    return true
}
fun main() {
    for (i in 1..19) {
        var n = "1".repeat(i).toLong()
        println("%d %b".format(n, isPrime(n)))
    }
}
