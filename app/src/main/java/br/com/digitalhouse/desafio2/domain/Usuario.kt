package br.com.digitalhouse.desafio2.domain

import java.io.Serializable

data class Usuario(val id: Int, val username: String, var senha: String): Serializable {
}