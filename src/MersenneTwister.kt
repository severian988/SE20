class MersenneTwister {
    var n = 10000
    var w = 31
    var r = 9
    var m = 14
    var f = 26
    var a = 17
    var u = 42
    var s = 11
    var t = 4
    var l = 35
    var d = 6
    var c =14
    var b = 3
    var MT = mutableListOf<Int>()
    var index = n+1
    var lower_mask = 1.shr(r) - 1
    var upper_mask = lower_mask.inv() and (1.shl(w) - 1)

    fun init_Mt(){
        for(i in 0..n){
            MT.add(0)
        }
    }

    fun seed_mt(seed:Int){
        init_Mt()
        index = n
        MT[0] = seed
        for (i in 1..(n-1)){
            MT[i] = (1.shl(w) - 1) and (f* (MT[i-1] xor (MT[i-1].shr(w-2)))+1)
        }
    }
    fun extract_number(): Int {
        if(index >= n){
            if(index>n){
                println("error:Generator was never seeded")
            }
            twist()
        }

        var y =MT[index]
        y = y xor (y.shr(u) and d)
        y = y xor (y.shl(s) and b)
        y = y xor (y.shl(t) and c)
        y = y xor (y.shr(l))
        index += 1
        return (y and (1.shl(w) - 1))
    }
    fun twist(){
        for(i in 0..(n-1)){
            var x = (MT[i] and upper_mask) + (MT[(i+1)%n] and lower_mask)
            var xA = x.shr(1)
            if ((x%2)!= 0){
                xA = xA xor a
            }
            MT[i] = MT[(i+m)%n] xor xA
        }
        index = 0
    }
}
fun main(){
    var NbGen = MersenneTwister()
    NbGen.seed_mt(22222)
    println(NbGen.extract_number())
    for(i in 0..100){
        println("draw $i: ${NbGen.extract_number()}")
    }
}