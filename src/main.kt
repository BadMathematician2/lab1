import java.lang.Exception
import kotlin.math.*

fun main(){

    val lab1:Parabolic = Parabolic(0 , 1 , 0 , 1 , 0.1 , 0.0025, 5.0 , { x, _ -> 2*sin(2*x)*sin(x)},
        {10*exp(it)} , {t -> sin(t)} , {10*cos(PI*it/2)} , { .0})
    try {
        lab1.isEverythingOk()
        lab1.prinResult(lab1.result())
    }
    catch (e: Exception)
    {
        println(e.message)
    }


}