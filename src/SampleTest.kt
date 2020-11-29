import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SampleTest {
      var s_ = Sample()

      /**
       * @author mori
       * This function checked 7 is a prime number, and 4 is not.
       */
      fun SampleTest00(){
            assertTrue { s_.isPrime(7) }
            assertEquals(s_.isPrime(4),false)
            println("Test000 is OK!")
      }

      /**
       * @author mori
       * Check the Carmichael numbers under 100000 are not a prime number.
       */
      fun SampleTest01(){
            val cnum = listOf(561L, 1105L, 1729L, 2465L, 2821L, 6601L, 8911L, 10585L, 15841L, 29341L, 41041L, 46657L, 52633L, 62745L, 63973L, 75361L)
            for (num in cnum){
                  assertFalse { s_.isPrime(num) }
            }
            println("Test001 is OK!")
      }
}

fun main(args: Array<String>){
      var stest = SampleTest()
      stest.SampleTest00()
      stest.SampleTest01()
}