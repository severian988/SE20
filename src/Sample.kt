import kotlin.system.measureTimeMillis

fun main() {
    val checker = Checker()
    val time = measureTimeMillis {

        val i_min = 49081L   //Lower bound
        val i_max = 49085L   //Upper bound
        var n = (10.toBigInteger().pow((i_min).toInt())-1.toBigInteger()).divide(9.toBigInteger())

        var primeRepunits = mutableListOf<Long>()

        for (i in i_min..i_max) {
            if(checker.isPrime(i)){
                //println("R_$i %b".format(checker.isPrimeRepunit(n)))
                if(checker.isPrimeRepunit(n)){
                    primeRepunits.add(i) //Add index of repunit n
                }
            }else{
                //println("R_$i false")
            }
            n = n * 10.toBigInteger() + 1.toBigInteger()

            //Every 500 repunits tested, report progress
            if(i%100 == 0L) {
                println("Last tested repunit R_$i; ${primeRepunits.size} total prime repunit found")
            }
        }

        //Once all repunits were tested, print final results :
        println("\n Prime repunits found are :")
        for(i in 0..primeRepunits.size-1){
            println("R_${primeRepunits[i]} is prime")
        }
    }
    println("\n Resolved in : $time ms")
}
