package br.com.digitalhouse.desafio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Snackbar.make(tela_login, "Senha incorreta", Snackbar.LENGTH_SHORT)
                .setAction("Ok", View.OnClickListener {
                    Log.d("tag", "Funcionou")
                })
                .show()
            //showSnackbar("Senha incorreta")
        }
    }

    /*fun showSnackbar(msg: String){
        val snack = Snackbar.make(tela_login, msg, Snackbar.LENGTH_SHORT)
        snack.setAction("Ok", View.OnClickListener {
            Log.d("tag", "Funcionou")
        })
        snack.show()
    }*/
}