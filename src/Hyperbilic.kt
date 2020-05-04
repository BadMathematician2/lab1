import kotlin.math.pow

class Hyperbilic (a:Int, b:Int, t0:Int, T:Int, h:Double, tay:Double, k:Double,
    f:(x:Double,t:Double) -> Double, m1:(t:Double) -> Double, m2:(t:Double) -> Double,
    phi:(x:Double) -> Double, psi:(x:Double) -> Double) : base(a, b, t0, T, h, tay, k,
    f, m1, m2, phi, psi)  {

        override fun result(): Array<DoubleArray> {
            val u: Array<DoubleArray> = Array(n+1) { DoubleArray(m+1) {0.0} }
            for (i in 1 until n) {
                u[i][0] = phi(a + i * h)
                u[i][1] = u[i][0]+tay*psi(a+i*h)
            }
            for (j in 0..m){
                u[0][j] = m1(t0 + j*tay)
                u[n][j] = m2(t0 + j*tay)
            }
            for (j in 1 until m)
                for (i in 1 until n)
                    u[i][j + 1] = 2*u[i][j] - u[i][j-1] + (tay * k ).pow(2)* (u[i - 1][j] - 2 * u[i][j] + u[i + 1][j]) / h.pow(2) +
                            tay.pow(2)*f(a + i*h, t0 + j*tay)

            return u
        }
    }
