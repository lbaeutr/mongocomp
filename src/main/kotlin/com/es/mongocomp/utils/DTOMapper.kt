//package com.es.mongocomp.utils
//
//import com.es.mongocomp.dto.UsuarioDTO
//import com.es.mongocomp.dto.UsuarioRegisterDTO
//import com.es.mongocomp.model.Direccion
//import com.es.mongocomp.model.Usuario
//
//
////object DTOMapper {
////
////    fun userDTOToEntity(usuarioInsertDTO: UsuarioRegisterDTO) : Usuario {
////        return Usuario(
////            usuarioInsertDTO.email,
////            usuarioInsertDTO.nombre,
////            usuarioInsertDTO.nick,
////            true,
////            listOf(usuarioInsertDTO.telefono1, usuarioInsertDTO.telefono2),
////            Direccion(
////                usuarioInsertDTO.calle,
////                usuarioInsertDTO.numero,
////                usuarioInsertDTO.cp,
////                usuarioInsertDTO.ciudad
////            )
////        )
////    }
////
////    fun userEntityToDTO(usuario: Usuario) : UsuarioRegisterDTO {
////
////        return UsuarioRegisterDTO(
////            usuario._id,
////            usuario.nombre,
////            usuario.nick,
////            usuario.telefonos[0] ?: "",
////            usuario.telefonos[1] ?: "",
////            usuario.direccion.calle,
////            usuario.direccion.num,
////            usuario.direccion.cp,
////            usuario.direccion.ciudad
////        )
////
////    }
////
////    fun listOfUserEntitiesToDTO(usuarios: List<Usuario>) : List<UsuarioRegisterDTO> {
////        return usuarios.map {
////            UsuarioRegisterDTO(
////                it._id,
////                it.nombre,
////                it.nick,
////                it.telefonos[0] ?: "",
////                it.telefonos[1] ?: "",
////                it.direccion.calle,
////                it.direccion.num,
////                it.direccion.cp,
////                it.direccion.ciudad
////            )
////        }
////
////    }
////}
//
//
//object DTOMapper {
//
//    fun usuarioRegisteredDTOToEntity(usuarioInsertDTO: UsuarioRegisterDTO, passwordEncoder: PasswordEncoder) : Usuario {
//        return Usuario(
//            _id = null,
//            username = usuarioInsertDTO.username,
//            password = passwordEncoder.encode(usuarioInsertDTO.password),
//            email = usuarioInsertDTO.email,
//            roles = usuarioInsertDTO.rol ?: "",
//            direccion = Direccion(
//                calle = usuarioInsertDTO.calle,
//                num = usuarioInsertDTO.num,
//                municipio = usuarioInsertDTO.municipio,
//                provincia = usuarioInsertDTO.provincia,
//                cp = usuarioInsertDTO.cp,
//                ciudad = usuarioInsertDTO.ciudad
//            ),
//        )
//    }
//
//    fun entityToUsuarioRegisteredDTO(usuario: Usuario) : UsuarioRegisterDTO {
//
//        return UsuarioRegisterDTO(
//            username = usuario.username,
//            email = usuario.email,
//            password = usuario.password,
//            passwordRepeat = usuario.password,
//            rol = usuario.roles,
//            calle = usuario.direccion.calle,
//            num = usuario.direccion.num,
//            municipio = usuario.direccion.municipio,
//            provincia = usuario.direccion.provincia,
//            cp = usuario.direccion.cp,
//            ciudad = usuario.direccion.ciudad,
//        )
//    }
//
//    fun usuarioEntityToUsuarioDTO(usuario: Usuario) : UsuarioDTO {
//        return UsuarioDTO(
//            username = usuario.username,
//            email = usuario.email,
//            rol = usuario.roles
//        )
//    }
//}