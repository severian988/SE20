import kotlin.math.*

fun isPrime(x:Long): Boolean{
    if(x==1L) return false

    var j = 3L

    while(j * j <x){
        if(x % j == 0L) {
            return false
        }
        j = j + 2L
    }
    return true
}
fun main() {
    var n = 0L
    for(i in 1L..19L){
        n = n * 10L + 1L
        println("%d %b".format(n, isPrime(n)))
    }
}