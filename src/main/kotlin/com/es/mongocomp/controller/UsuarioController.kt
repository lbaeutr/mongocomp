package com.es.mongocomp.controller

import com.es.mongocomp.domain.Log
import com.es.mongocomp.dto.UsuarioRegisterDTO
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

//    @Autowired
//    private lateinit var usuarioService : UsuarioService
//    //todo: add tokenService
//    @Autowired
//    //private lateinit var tokeService: TokenService
//    //todo: add authenticationManager
//   // @Autowired
//    //private lateinit var authenticationManager: AuthenticationManager


    //lo de abajo descomentado es lo que estaba antes

//    @PostMapping("/")
//    fun insert(
//        httpRequest: HttpServletRequest,
//        @RequestBody usuarioRegisterDTO: UsuarioRegisterDTO
//    ) : ResponseEntity<UsuarioRegisterDTO>{
//
//        val usuarioInsertadoDTO = usuarioService.insertUser(usuarioRegisterDTO)
//
//        LogUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))
//
//        return ResponseEntity(usuarioInsertadoDTO, HttpStatus.CREATED)
//
//    }

    /*
    Esto esta montado por Bouza

        @PostMapping("/register")
    fun insert(
        httpRequest: HttpServletRequest,
        @RequestBody usuarioRegisterDTO: UsuarioRegisterDTO
    ) : ResponseEntity<UsuarioDTO>?{

        usuarioService.insertUser(usuarioRegisterDTO)

        return ResponseEntity(null, HttpStatus.CREATED)

    }
     */

    /*
    Esto esta montado por Bouza para el login

       @PostMapping("/login")
    fun login(@RequestBody usuario: LoginUsuarioDTO) : ResponseEntity<Any>? {

        val authentication: Authentication
        try {
            authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(usuario.username, usuario.password))
        } catch (e: AuthenticationException) {
            throw UnauthorizedException("Credenciales incorrectas")
        }

        // SI PASAMOS LA AUTENTICACIÓN, SIGNIFICA QUE ESTAMOS BIEN AUTENTICADOS
        // PASAMOS A GENERAR EL TOKEN
        var token = tokenService.generarToken(authentication)

        return ResponseEntity(mapOf("token" to token), HttpStatus.CREATED)
    }

     */


    // lo de abajo descomentado es lo que estaba antes
//    @GetMapping("/byCiudad/{ciudad}")
//    fun getByCiudad(
//        httpRequest: HttpServletRequest,
//        @PathVariable ciudad: String
//    ) : ResponseEntity<List<UsuarioRegisterDTO>>{
//
//        LogUtils.writeLog(Log(httpRequest.method, httpRequest.requestURI, true, HttpStatus.OK))
//
//        return ResponseEntity(usuarioService.getUsuarioByCiudad(ciudad), HttpStatus.OK)
//
//    }

}