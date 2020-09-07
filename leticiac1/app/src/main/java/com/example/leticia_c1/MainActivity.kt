package com.example.leticia_c1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validacao(componente: View) {
        val nome = et_nome.text
        val saldo = et_saldo.text.toString()
        val produto = et_produto.text.toString()

        if (nome.length < 3) {
            et_nome.error = "Nome Inválido"
            et_nome.requestFocus()

            return
        }
        if (saldo.isEmpty() || saldo.toDouble() < 0) {
            et_saldo.error = "Valor Inválido"
            et_saldo.requestFocus()

            return
        }
        if (produto.isEmpty() || produto.toDouble() < 0) {
            et_produto.error = "Valor Inválido"
            et_produto.requestFocus()

            return
        }

        if (saldo.toDouble() < produto.toDouble()) {
            text_resposta.text = "${nome}, você não possui saldo suficiente para isso! ;-;"
            text_resposta.setTextColor(Color.parseColor("#ac0602"))
            text_resposta.visibility = View.VISIBLE

        }else if (saldo.toDouble() == produto.toDouble()){
            text_resposta.text = "${nome}, você possui saldo, porém ficará sem dinheiro! '~'"
            text_resposta.setTextColor(Color.parseColor("#ffd700"))
            text_resposta.visibility = View.VISIBLE

        } else if (saldo.toDouble() > produto.toDouble()){
            text_resposta.text = "Ebaa! ${nome}, você tem dinheiro suficiente para está compra!\nAinda sobrará R$${saldo.toDouble() - produto.toDouble()} ^-^"
            text_resposta.setTextColor(Color.GREEN)
            text_resposta.visibility = View.VISIBLE

        }

    }
}