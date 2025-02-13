package com.es.mongocomp.dto

data class UsuarioRegisterDTO(
    val email: String,
    val nombre: String,
    val nick: String,
    val telefono1: String?,
    val telefono2: String?,
    val calle: String,
    val numero: String,
    val cp: String,
    val ciudad: String
)


/*
Esto es de bouza

data class UsuarioDTO(
    val username: String,
    val email: String,
    val rol: String?
)

 */
