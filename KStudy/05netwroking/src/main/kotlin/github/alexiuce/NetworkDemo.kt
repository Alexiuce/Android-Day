package github.alexiuce
import okhttp3.*
import java.io.IOException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager
import javax.swing.plaf.nimbus.NimbusLookAndFeel

/**
 * Created by Alexcai on 2018/3/10.
 */


class ResponseObject: Callback{
    override fun onFailure(call: Call?, e: IOException?) {
       println("failure" + e.toString())
    }

    override fun onResponse(call: Call?, response: Response?) {
       println("success "+ response?.body()?.string())
    }
}

class HttsTrust: X509TrustManager{
    override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {

    }

    override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
       return arrayOf()
    }
}


fun main(args: Array<String>) {

    var sslFactory : SSLSocketFactory? = null
    try {
        val sc = SSLContext.getInstance("TLS")
        sc.init(null, arrayOf(HttsTrust()), SecureRandom())
        sslFactory = sc.socketFactory
    }catch (e: IOException){

    }
    if (sslFactory == null) return


    val client = OkHttpClient().newBuilder().sslSocketFactory(sslFactory).build()
    val request = Request.Builder().get().url("https://httpbin.org/get").build()
    client.newCall(request).enqueue(ResponseObject())
}