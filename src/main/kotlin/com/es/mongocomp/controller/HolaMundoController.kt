package com.es.mongocomp.controller

import com.es.mongocomp.model.Noticia
import com.es.mongocomp.repository.NoticiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
class HolaMundoController() {

    @Autowired
    private lateinit var noticiaRepository: NoticiaRepository

    @GetMapping("/holamundo")
    fun getHolaMundo() : String {

        val noticia = Noticia(
            null,
            "NOTICIA INSERTADA AHORA",
            "Se cancelan las clases hasta nuevo aviso",
            Date.from(Instant.now()),
            listOf("MUNDO", "ACTUALIDAD") ,
            "idClienteDePrueba")

        noticiaRepository.insert(noticia)

        return "<h1>HOLA MUNDO</h1>"
    }

}