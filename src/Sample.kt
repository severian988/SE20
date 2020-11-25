import java.math.BigInteger


//Compute a^d % num
fun myPow(a:BigInteger,d:BigInteger,num:BigInteger) : BigInteger{
    var result = 1.toBigInteger()
    var x =  a % num
    var y = d

    while(y > 0.toBigInteger()) {
        if (y % 2.toBigInteger() == 1.toBigInteger()) {
            result = (result * x) % num
        }
        y /= 2.toBigInteger()
        x = (x.pow(2)) % num
    }
    return result
}

fun millerTest(d:BigInteger, num:BigInteger, a:BigInteger): Boolean {

    var x = myPow(a, d, num)
    var k = d
    if (x == 1.toBigInteger() || x == num - 1.toBigInteger()){
        return true
    }

    while (k != num - 1.toBigInteger()) {
        x = (x.pow(2)) % num
        k *= 2.toBigInteger()
        if (x == 1.toBigInteger()) return false
        if (x == num - 1.toBigInteger()) return true
    }
    return false
}


fun isPrime(num:BigInteger): Boolean{
    //Checking corner cases
    if (num <= 1.toBigInteger() || num == 4.toBigInteger()) return false
    if (num == 2.toBigInteger()) return true

    //Hardwritten list of already known primes
    var primes = listOf(2, 3, 5, 7, 11, 13,17,31,61,73)

    //Finding an odd number d such that num-1 can be written as d*2^s
    var s = 0
    var d = num - 1.toBigInteger()

    while(d % 2.toBigInteger() == 0.toBigInteger()) {
        s++
        d /= 2.toBigInteger()
    }
    assert(2.toBigInteger().pow(s) * d == num - 1.toBigInteger())


    for (a in primes) {
        if (a.toBigInteger() >= num) {
            break
        }
        if (!millerTest(d, num, a.toBigInteger())){
        return false
        }
    }
    return true
}


fun main() {
    //How much repunit we want to check
    var n = 317
    // Printing the Rn from 1 to howMuch with if it is prime or not
    for (i in 1..n) {
        var r = ((10.toBigDecimal().pow(i)) / 9.toBigDecimal()).toBigInteger()
        if (isPrime(i.toBigInteger())) {
            println("R%d - %d %b".format(i, r, isPrime(r)))
        } else{
            println("R%d - %d %s".format(i, r, "false"))
        }
    }
}
