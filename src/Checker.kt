import java.math.BigInteger

class Checker {
    val aSample: List<Long> = listOf(2,3,5,7,11,13,17,31,61,73);

    fun checkNum(num: BigInteger):Pair<BigInteger,BigInteger>{
        var s: BigInteger = BigInteger.ZERO;
        var d: BigInteger = num - BigInteger.ONE;
        assert(d> BigInteger.ZERO);
        while(d % BigInteger.TWO == BigInteger.ZERO){
            s += BigInteger.ONE;
            d = d.shr(1);
        }
        assert( myPow(BigInteger.TWO,s,num)== num- BigInteger.ONE  );
        return s to d;
    }

    fun myPow(x:BigInteger,y:BigInteger,n:BigInteger): BigInteger{
        var result: BigInteger = BigInteger.ONE;
        var x = x % n;
        var y = y;
        while(y > BigInteger.ZERO) {
            if (y % BigInteger.TWO != BigInteger.ZERO) {
                result *= x;
                result %= n;
            }
            y = y.shr(1);
            x = x.pow(2) % n;
        }
        return result;
    }
    fun millerTest(d:BigInteger,num:BigInteger,a:BigInteger): Boolean{
        var x = myPow(a,d,num);
        if(x == BigInteger.ONE || x == num - BigInteger.ONE) return true;
        var d = d;
        while(d != num - BigInteger.ONE) {
            x = x.pow(2) % num;
            d *= BigInteger.TWO;
            if (x == BigInteger.ONE) return false;
            if (x == num - BigInteger.ONE) return true;
        }
        return false;
    }
    fun isPrime(num:BigInteger): Boolean{
        if(num == BigInteger.valueOf(1) || num == BigInteger.valueOf(4)) return false
        if(num == BigInteger.valueOf(2)) return true

        val (s,d) = checkNum(num);
        for ( a in aSample ){
            var a = BigInteger.valueOf(a);
            if(a >= num) break;
            if(!millerTest(d,num,a)) return false;
        }
        return true
    }
    fun isRepunitPrime(i:Long,n:BigInteger): Boolean{
        var check = n
        for(j in 1..i){
            assert(check % BigInteger.valueOf(10) == BigInteger.ONE)
            check /= BigInteger.valueOf(10)
        }
        if( isPrime(BigInteger.valueOf(i) ) ) return isPrime(n);
        return false
    }
}