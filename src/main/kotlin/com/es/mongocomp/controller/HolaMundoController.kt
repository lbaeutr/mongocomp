package com.es.mongocomp.controller

import com.es.mongocomp.model.Log
import com.es.mongocomp.model.Noticia
import com.es.mongocomp.repository.NoticiaRepository
import com.es.mongocomp.utils.LogUtils
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpRequest
import java.time.Instant
import java.util.*

@RestController
class HolaMundoController() {

    @Autowired
    private lateinit var noticiaRepository: NoticiaRepository
    @Autowired
    private lateinit var logUtils: LogUtils

    @GetMapping("/holamundo")
    fun getHolaMundo(httpRequest: HttpServletRequest) : String {

        val noticia = Noticia(
            null,
            "NOTICIA INSERTADA AHORA",
            "Se cancelan las clases hasta nuevo aviso",
            Date.from(Instant.now()),
            listOf("MUNDO", "ACTUALIDAD") ,
            "idClienteDePrueba")

        //noticiaRepository.insert(noticia)
        logUtils.prueba();
        logUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))

        return "<h1>HOLA MUNDO</h1>"
    }




}