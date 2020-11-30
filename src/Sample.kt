import kotlin.system.measureTimeMillis

fun main() {
    val checker = Checker()
    val time = measureTimeMillis {
        var n = 1.toBigInteger()

        var primeRepunits = mutableListOf<Long>()
        var numTrue = 0L
        var numFalse = 0L

        for (i in 1L..1031L) {
            if(checker.isPrime(i)){
                //println("R_$i %b".format(checker.isPrimeRepunit(n)))
                if(checker.isPrimeRepunit(n)){
                    numTrue += 1
                    primeRepunits.add(i) //Add index of repunit n
                }
                else{
                    numFalse += 1
                }
            }else{
                //println("R_$i false")
                numFalse += 1
            }
            n = n * 10.toBigInteger() + 1.toBigInteger()

            //Every 500 repunits tested, report progress
            if(i%500 == 499L) {
                println("Last tested repunit R_$i; $numTrue prime numbers found")
            }
        }

        //Once all repunits were tested, print final results :
        println("\n Prime repunits found are : :")
        for(i in 1..primeRepunits.size-1){
            println("R_${primeRepunits[i]} is prime")
        }
    }
    println("\n Resolved in : $time ms")
}
