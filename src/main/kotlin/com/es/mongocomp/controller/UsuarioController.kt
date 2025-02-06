package com.es.mongocomp.controller

import com.es.mongocomp.model.Usuario
import com.es.mongocomp.domain.Log
import com.es.mongocomp.dto.UsuarioDTO
import com.es.mongocomp.repository.UsuarioRepository
import com.es.mongocomp.service.UsuarioService
import com.es.mongocomp.utils.LogUtils
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    @Autowired
    private lateinit var usuarioService : UsuarioService

    @PostMapping("/")
    fun insert(
        httpRequest: HttpServletRequest,
        @RequestBody usuarioDTO: UsuarioDTO
    ) : ResponseEntity<UsuarioDTO>{

        val usuarioInsertadoDTO = usuarioService.insertUser(usuarioDTO)

        LogUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))

        return ResponseEntity(usuarioInsertadoDTO, HttpStatus.CREATED)

    }

    @GetMapping("/byCiudad/{ciudad}")
    fun getByCiudad(
        httpRequest: HttpServletRequest,
        @PathVariable ciudad: String
    ) : ResponseEntity<List<UsuarioDTO>>{

        LogUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))

        return ResponseEntity(usuarioService.getUsuarioByCiudad(ciudad), HttpStatus.OK)

    }

}