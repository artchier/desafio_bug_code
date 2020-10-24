package br.com.digitalhouse.desafio2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import br.com.digitalhouse.desafio2.MainActivityContract
import br.com.digitalhouse.desafio2.R
import br.com.digitalhouse.desafio2.domain.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_entradas.*
import kotlinx.android.synthetic.main.tab_gastos.*
import kotlinx.android.synthetic.main.tab_home.*

class MainActivity : AppCompatActivity(), MainActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario: Usuario = intent.getSerializableExtra("key") as Usuario

        Toast.makeText(this, "Bem vindo ${usuario.username}", Toast.LENGTH_SHORT).show()
        toolbar_wallet.setNavigationOnClickListener {
            val callLoginActivity: Intent = Intent(this, LoginActivity::class.java)
            callLoginActivity.putExtra("key", usuario)
            startActivity(callLoginActivity)
        }

        callEntradasFragment()

        home.setOnClickListener {
            callHomeFragment()
        }

        entradas.setOnClickListener {
            callEntradasFragment()
        }

        gastos.setOnClickListener {
            callGastosFragment()
        }
    }

    override fun callHomeFragment() {
        line_home.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSelected))
        icon_home.setColorFilter(ContextCompat.getColor(this, R.color.colorSelected))
        text_home.setTextColor(ContextCompat.getColor(this, R.color.colorSelected))

        line_entradas.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_entradas.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_entradas.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        line_gastos.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_gastos.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_gastos.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_layout, homeFragment)
            commit()
        }
    }

    override fun callEntradasFragment() {
        line_home.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_home.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_home.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        line_entradas.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSelected))
        icon_entradas.setColorFilter(ContextCompat.getColor(this, R.color.colorSelected))
        text_entradas.setTextColor(ContextCompat.getColor(this, R.color.colorSelected))

        line_gastos.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_gastos.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_gastos.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        val entradasFragment = EntradasFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_layout, entradasFragment)
            commit()
        }
    }

    override fun callGastosFragment() {
        line_home.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_home.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_home.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        line_entradas.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
        icon_entradas.setColorFilter(ContextCompat.getColor(this, android.R.color.white))
        text_entradas.setTextColor(ContextCompat.getColor(this, android.R.color.white))

        line_gastos.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSelected))
        icon_gastos.setColorFilter(ContextCompat.getColor(this, R.color.colorSelected))
        text_gastos.setTextColor(ContextCompat.getColor(this, R.color.colorSelected))

        val gastosFragment = GastosFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_layout, gastosFragment)
            commit()
        }
    }
}