package br.com.example.splashactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //pausa na execução - classe handler
        Handler().postDelayed(Runnable {
            //Abrir a tela web
           startActivity(Intent(this@MainActivity, WebActivity::class.java))

            //Tirando a tela do empilhamento
            finish()
        }, 3000)
    }
}
