import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckerTest {
    var c_ = Checker()

    /**
     * @author mori 2020/11/30
     * Check the Carmichael numbers under 100000 are not a prime number.
     */
    fun CheckerTest01(){
        val cnum = listOf(561L, 1105L, 1729L, 2465L, 2821L, 6601L, 8911L, 10585L, 15841L, 29341L, 41041L, 46657L, 52633L, 62745L, 63973L, 75361L)
        for (num in cnum){
            assertFalse { c_.isPrime(num) }
            assertFalse { c_.isPrimeRepunit(num.toBigInteger()) }
        }
        println("Test001 is OK!")
    }
}

fun main(args: Array<String>){
    var ctest = CheckerTest()
    ctest.CheckerTest01()
}
