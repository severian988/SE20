import kotlin.math.*

class Sample {
    fun isPrime(x: Long): Boolean {
        if (x == 1L) return false

        for (j in 2L..x / 2) {
            if (x % j == 0L) {
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
     var s = Sample()
     for (i in 1L..20L) {
        var n = (10.0.pow(i.toDouble()) / 9).toLong()
        println("%d %b".format(n, s.isPrime(n)))
    }
}
