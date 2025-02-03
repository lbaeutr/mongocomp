package com.es.mongocomp.controller

import com.es.mongocomp.exception.exceptions.NotFoundException
import com.es.mongocomp.model.Log
import com.es.mongocomp.model.Noticia
import com.es.mongocomp.repository.NoticiaRepository
import com.es.mongocomp.utils.LogUtils
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
@RequestMapping("/noticias")
class NoticiaController {

    @Autowired
    private lateinit var noticiaRepository: NoticiaRepository
    @Autowired
    private lateinit var logUtils: LogUtils

    @GetMapping("/")
    fun getAll(httpRequest: HttpServletRequest) : ResponseEntity<List<Noticia>> {

        val noticias: List<Noticia>  = noticiaRepository.findAll()
        logUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))

        return ResponseEntity(noticias, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insert(httpRequest: HttpServletRequest, @RequestBody noticia: Noticia) : ResponseEntity<Noticia> {


        val noticiaInsertada = noticiaRepository.insert(noticia)
        logUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.CREATED))

        return ResponseEntity(noticiaInsertada, HttpStatus.CREATED)
    }

    @GetMapping("/{titulo}")
    fun getOne(
        @PathVariable titulo: String,
        httpRequest: HttpServletRequest
    ) : ResponseEntity<Noticia> {

        val noticia = noticiaRepository.findByTitulo(titulo)?.firstOrNull()

        if (noticia != null) {
            logUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))
            return ResponseEntity(noticia, HttpStatus.OK)
        } else {
            throw NotFoundException("Noticia no encontrada")
        }


    }

    @DeleteMapping("/{titulo}")
    fun deleteOne(
        @PathVariable titulo: String,
        httpRequest: HttpServletRequest
    ) : ResponseEntity<Noticia> {

        val noticia = noticiaRepository.findByTitulo(titulo)?.firstOrNull()


        if (noticia != null) {
            noticiaRepository.delete(noticia)
            logUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))
            return ResponseEntity(noticia, HttpStatus.OK)
        } else {
            throw NotFoundException("Noticia no encontrada")
        }


    }

    @PutMapping("/{titulo}")
    fun updateOne(
        @PathVariable titulo: String,
        @RequestBody nuevaNoticia: Noticia,
        httpRequest: HttpServletRequest
    ) : ResponseEntity<Noticia>? {

       return null


    }




}