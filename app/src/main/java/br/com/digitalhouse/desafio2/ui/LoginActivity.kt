package br.com.digitalhouse.desafio2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafio2.R
import br.com.digitalhouse.desafio2.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usuario: Usuario? = intent.getSerializableExtra("key") as? Usuario

        login.setOnClickListener {
            val callGastosActivity: Intent = Intent(this, MainActivity::class.java)
            when {
                user_edit.text.isNullOrBlank() || password_edit.text.isNullOrBlank() ->
                    Snackbar.make(
                        snack_layout,
                        "Preencha os dados corretamente",
                        Snackbar.LENGTH_SHORT
                    ).show()
                else -> {
                    callGastosActivity.putExtra(
                        "key", Usuario(
                            0, user_edit.text.toString(),
                            password_edit.text.toString()
                        )
                    )
                    startActivity(callGastosActivity)
                }
            }
        }

        cadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }
        user_edit.setText(usuario?.username)
        password_edit.setText(usuario?.senha)
    }
}