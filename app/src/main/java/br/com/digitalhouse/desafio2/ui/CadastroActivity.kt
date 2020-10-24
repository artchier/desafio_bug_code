package br.com.digitalhouse.desafio2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafio2.R
import br.com.digitalhouse.desafio2.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        cadastro.setOnClickListener {
            val callLoginActivity: Intent = Intent(this, LoginActivity::class.java)
            when(comparePassword(new_password_confirm.text.toString(), new_password.text.toString())){
                true -> {
                    callLoginActivity.putExtra("key", Usuario(0, new_user.text.toString(), new_password.text.toString()))
                    startActivity(callLoginActivity)
                    finish()
                }
                false -> {
                    when{
                        new_user.text.toString() == "" || new_email.text.toString() == "" ->
                            Snackbar.make(snack_layout, "Preencha os dados de cadastro corretamente", Snackbar.LENGTH_SHORT)
                                .show()
                        else -> Snackbar.make(snack_layout, "Repita a senha corretamente", Snackbar.LENGTH_SHORT)
                                    .show()
                    }
                }
            }
        }
    }

    private fun comparePassword(passwordConfirm: String, password: String): Boolean{
        return when{
            passwordConfirm == "" || password == "" -> false
            else -> passwordConfirm == password
        }
    }
}