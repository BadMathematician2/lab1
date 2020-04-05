import kotlin.math.pow

abstract class base(
     val a: Int,  val b: Int,  val t0: Int,  val T: Int, val h: Double,
     val tay: Double,  val k: Double, val f: (x: Double, t: Double) -> Double,
     val m1: (t: Double) -> Double, val m2: (t: Double) -> Double,
     val phi: (x: Double) -> Double,  val psi: (x: Double) -> Double
) {
   open var n = (( b - a ) / h).toInt()
   open var m = (( T - t0 ) / tay).toInt()


    abstract fun result( ):Array< DoubleArray>

    open fun prinResult(z:Array< DoubleArray>){

        var i = 0; var j = 0
        for ( i in 0..n)
        {
            for (j in 0..m )
                println("u( ${(a+i*h).toInt()},${( ( a+i*h - (a+i*h).toInt() ) *10.0.pow( numbersAfterPoint(h) ) ).toInt()}; " +
                        " ${(t0+j*tay).toInt()},${( ( t0+j*tay - (t0+j*tay).toInt() ) *10.0.pow( numbersAfterPoint(tay) ) ).toInt()} )  =  ${z[i][j]}")

        }
    }

    open fun isEverythingOk(){

         when {
            (a>=b)||(t0>=T) -> throw Exception("Ліва межа має бути менша")
            (t0<0) -> throw Exception("Час має бути більший від нуля")
            (phi(0.0)!=m1(0.0)) -> throw Exception("Не виконуються умови узгожєення")
             (h<=0)||(tay<=0) -> throw Exception("Крок має бути більший від нуля")

        }


    }

        fun numbersAfterPoint(x:Double):Int{
            val i = x.toInt()
            var j = 0
            while ( x*10.0.pow(j)  -  (x*10.0.pow(j)).toInt()   >0  )
                j++
            return j
        }

}