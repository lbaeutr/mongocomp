//package com.es.mongocomp.service
//
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication
//import org.springframework.beans.factory.annotation.Autowired
//
//import org.springframework.stereotype.Service
//import java.time.Duration
//import java.time.Instant
//import java.util.*
//
//@Service
//class TokenService {
//
//    @Autowired
//    private lateinit var jwtEncoder: JwtEncoder
//
//    fun generarToken(authentication: Authentication) : String {
//
//        println("diediejdei")
//
//        val roles: String = authentication.authorities.joinToString(" ") { it.authority } // Contiene los roles del usuario
//
//        val payload: JwtClaimsSet = JwtClaimsSet.builder()
//            .issuer("self")
//            .issuedAt(Instant.now())
//            .expiresAt(Date().toInstant().plus(Duration.ofHours(1)))
//            .subject(authentication.name)
//            .claim("roles", roles)
//            .build()
//
//        return jwtEncoder.encode(JwtEncoderParameters.from(payload)).tokenValue;
//    }
//}