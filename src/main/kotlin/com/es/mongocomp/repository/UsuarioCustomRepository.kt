package com.es.mongocomp.repository

import com.es.mongocomp.model.Usuario

interface UsuarioCustomRepository {
    fun findByCiudad(ciudad: String): List<Usuario>
}

/*
INTERFAZ que contiene métodos para buscar en la base de datos usando
queries personalizadas.

Hacemos esto porque muchas veces, los métodos que nos proporciona
MongoRepository no son suficientes, y vamos a tener que realizar búsquedas
avanzadas o que requieren mayor flexibilidad.

En la interfaz sólo ponemos los métodos sin implementarlos, estos serán
implementados en la clase UsuarioCustomRepositoryImpl
 */