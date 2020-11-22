# 11の次のRepunit 素数を見つけるために，src フォルダ内に Sample.kt を作成したが，途中からオーバーフローを起こしてしまい，うまくプログラムが動作していない．これを修正して 11 の次の Repunit 素数を発見できるようにプログラムを拡張したい．誰かいいアイディアないですか？
import kotlin.math.*

fun isPrime(x:Long): Boolean{
    if(x==1L) return false

    for (j in 2L..x / 2) {
            if (x % j == 0L) {
                return false
            }
    }
    return true
}
fun main() {
    for (i in 1L..16L) {
        var n = (10.0.pow(i.toDouble()) / 9).toLong()
        println("%d %b".format(n, isPrime(n)))
    }
}
