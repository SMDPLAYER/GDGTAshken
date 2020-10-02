package uz.smd.gdgtashkent.util


import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.pixplicity.sharp.Sharp
import okhttp3.*
import uz.smd.gdgtashkent.R
import java.io.IOException
import java.io.InputStream


object Utils {
    private var httpClient: OkHttpClient? = null
    fun fetchSvg(context: Context, url: String?, target: ImageView) {
        if (httpClient == null) {
            // Use cache for performance and basic offline capability
            httpClient = OkHttpClient.Builder()
                .cache(Cache(context.getCacheDir(), 5 * 1024 * 1014))
                .build()
        }
        val request: Request = Request.Builder().url(url).build()
        httpClient!!.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }

            @Throws(IOException::class)
            override fun onResponse(call: Call?, response: Response) {
                val stream: InputStream = response.body()!!.byteStream()
                Sharp.loadInputStream(stream).into(target)
                stream.close()
            }
        })
    }
}
