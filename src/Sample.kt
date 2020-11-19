import kotlin.math.*

fun isPrime(x:Long): Boolean{
    if(x==1L) return false

    for (j in 2L..(sqrt(x.toDouble())).toLong()) {
        if (x % j == 0L) {
            return false
        }
    }
    return true
}
fun main() {
    var n = 0L
    for(i in 1L..19L){
        n += (10.0.pow(i.toDouble()-1.0)).toLong()
        println("%d %b".format(n, isPrime(n)))
    }
}
