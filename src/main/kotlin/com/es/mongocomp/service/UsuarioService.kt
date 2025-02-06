package com.es.mongocomp.service

import com.es.mongocomp.model.dto.UsuarioDTO
import com.es.mongocomp.repository.UsuarioRepository
import com.es.mongocomp.utils.DTOMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    private lateinit var dtoMapper: DTOMapper

    fun insertUser(usuarioDTO: UsuarioDTO) : UsuarioDTO{

        val usuario = dtoMapper.userDTOToEntity(usuarioDTO)

        usuarioRepository.insert(usuario)

        return dtoMapper.userEntityToDTO(usuario)

    }

}