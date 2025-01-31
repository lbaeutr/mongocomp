package com.es.mongocomp.repository

import com.es.mongocomp.model.Noticia
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NoticiaRepository : MongoRepository<Noticia, String> {
}