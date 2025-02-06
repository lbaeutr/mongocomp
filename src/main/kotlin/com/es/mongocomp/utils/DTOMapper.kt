package com.es.mongocomp.utils

import com.es.mongocomp.model.Usuario
import com.es.mongocomp.model.dto.UsuarioDTO
import org.springframework.stereotype.Component

@Component
class DTOMapper {

    fun userDTOToEntity(usuarioInsertDTO: UsuarioDTO) : Usuario {
        return Usuario(
            usuarioInsertDTO.email,
            usuarioInsertDTO.nombre,
            usuarioInsertDTO.nick,
            true,
            listOf(usuarioInsertDTO.telefono1, usuarioInsertDTO.telefono2)
        )
    }

    fun userEntityToDTO(usuario: Usuario) : UsuarioDTO {

        return UsuarioDTO(
            usuario._id,
            usuario.nombre,
            usuario.nick,
            usuario.telefonos[0] ?: "",
            usuario.telefonos[1] ?: ""
        )

    }
}