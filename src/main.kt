import java.lang.Exception
import kotlin.math.*

fun main(){

    val lab1:Parabolic = Parabolic(0 , 1 , 0 , 1 , 0.1 , 0.0025, 5.0 , { x, t -> 2*sin(2*x)*sin(x)},
        {t -> 10*exp(t)} , {t -> sin(t)} , {x -> 10*cos(PI*x/2)} , {x -> 0.0})
    try {
        lab1.isEverythingOk()
        lab1.prinResult(lab1.result())
    }
    catch (e: Exception)
    {
        println(e.message)
    }


}