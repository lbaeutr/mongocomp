package com.es.mongocomp.controller

import com.es.mongocomp.model.dto.UsuarioDTO
import com.es.mongocomp.service.UsuarioService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

        return ResponseEntity(usuarioInsertadoDTO, HttpStatus.CREATED)

    }

}