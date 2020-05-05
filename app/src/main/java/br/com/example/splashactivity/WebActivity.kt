package br.com.example.splashactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
          //habilitando webView
        wbvSite.settings.javaScriptEnabled = true
        wbvSite.loadUrl("https://www.caboclodistribuidor.com.br/")
        //dicas stackoverflow
        //Este código irá fazer com que todos os links abram dentro da webviw

        wbvSite.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return if (url.contains("https://www.caboclodistribuidor.com.br/")) {
                    wbvSite.loadUrl(url)
                    false
                } else {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                    true
                }
            }
        })
    }
}
