package com.es.mongocomp.dto

data class UsuarioDTO(
    val username: String,
    val email: String,
    val rol: String?
)