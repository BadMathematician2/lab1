import java.lang.Exception
import kotlin.math.*

fun main(){
    println("Write tay:")
    val tay = readLine()!!.toDouble()
    val lab1:Parabolic = Parabolic(0 , 1 , 0 , 1 , 0.1 , tay, 5.0 , { x, _ -> 2*sin(2*x)*sin(x)},
        {10*exp(it)} , {t -> sin(t)} , {10*cos(PI*it/2)} , { .0})
    val lab2 = Hyperbilic(0,1,0,2,0.1,tay,1.0,{x,t->t* cos(x)},{ t ->t},
        {t-> exp(t)},{x-> (sin(x*PI/2)).pow(2)},{x-> exp(x)})
    try {
        lab2.isEverythingOk()
        lab2.prinResult(lab2.result())
    }
    catch (e: Exception)
    {
        println(e.message)
    }

}