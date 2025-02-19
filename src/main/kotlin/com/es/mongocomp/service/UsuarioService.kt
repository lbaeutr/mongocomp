//package com.es.mongocomp.service
//
//import com.es.mongocomp.exception.exceptions.NotFoundException
//import com.es.mongocomp.dto.UsuarioRegisterDTO
//import com.es.mongocomp.model.Usuario
//import com.es.mongocomp.repository.UsuarioRepository
//import com.es.mongocomp.utils.DTOMapper
//import org.apache.coyote.BadRequestException
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//class UsuarioService : UserDetailsService {
//
//    @Autowired
//    private lateinit var usuarioRepository: UsuarioRepository
//    @Autowired
//    private lateinit var passwordEncoder: PasswordEncoder
//    @Autowired
//    private lateinit var apiService: ExternalApiService
//
//
//    override fun loadUserByUsername(username: String?): UserDetails {
//        var usuario: Usuario = usuarioRepository
//            .findByUsername(username!!)
//            .orElseThrow {
//                UnauthorizedException("$username no existente")
//            }
//
//        return User.builder()
//            .username(usuario.username)
//            .password(usuario.password)
//            .roles(usuario.roles)
//            .build()
//    }
//
//    fun insertUser(usuarioInsertadoDTO: UsuarioRegisterDTO) : UsuarioDTO? {
//
//        if(usuarioInsertadoDTO.username.isBlank()
//            || usuarioInsertadoDTO.email.isBlank()
//            || usuarioInsertadoDTO.password.isBlank()
//            || usuarioInsertadoDTO.passwordRepeat.isBlank()){
//
//            throw BadRequestException("Uno o más campos vacios")
//        }
//
//        if(usuarioRepository.findByUsername(usuarioInsertadoDTO.username).isPresent){
//            throw Exception("Usuario ${usuarioInsertadoDTO.username} ya está registrado")
//        }
//
//        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
//
//        if (!emailRegex.matches(usuarioInsertadoDTO.email)) {
//            throw BadRequestException("El email no es válido")
//        }
//
//        if (usuarioInsertadoDTO.password != usuarioInsertadoDTO.passwordRepeat) {
//            throw BadRequestException("Las contraseñas no coinciden")
//        }
//
//        val usuario = DTOMapper.usuarioRegisteredDTOToEntity(usuarioInsertadoDTO, passwordEncoder)
//        val datosProvincias = apiService.obtenerDatosDesdeApi()
//
//        var cpro = ""
//
//        if(datosProvincias?.data != null) {
//            datosProvincias.data.stream().filter {
//                if (it.PRO == usuario.direccion.provincia.uppercase()) {
//                    cpro = it.CPRO
//                }
//                it.PRO == usuario.direccion.provincia.uppercase()
//            }.findFirst().orElseThrow {
//                NotFoundException("Provincia ${usuario.direccion.provincia.uppercase()} no válida.")
//            }
//        }
//
//        val datosMunicipios = apiService.obtenerMunicipios(cpro)
//
//        if(datosMunicipios?.data != null) {
//            datosMunicipios.data.stream().filter {
//                it.DMUN50 == usuario.direccion.municipio.uppercase()
//            }.findFirst().orElseThrow {
//                NotFoundException("Municipio ${usuario.direccion.municipio.uppercase()} no válido.")
//            }
//        }
//
//        usuarioRepository.insert(usuario)
//
//        return DTOMapper.usuarioEntityToUsuarioDTO(usuario)
//    }
//}