package com.es.mongocomp.repository.impl

import com.es.mongocomp.model.Noticia
import com.es.mongocomp.repository.NoticiaCustomRepository
import com.mongodb.client.model.Filters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class NoticiaCustomRepositoryImpl : NoticiaCustomRepository {

    // Necesitamos la bd para acceder a la colección
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate
    override fun getNoticiasBetweenDates(startDate: Date, endDate: Date): List<Noticia> {

        // 1º Obtener la BD
        val db = mongoTemplate.db
        // 2º Obtener la colección
        val coll = db.getCollection("collNoticias", Noticia::class.java)

        // 3º Poner los Filters
        val filter = Filters.and(
            Filters.gte("fechaPub", startDate),
            Filters.lte("fechaPub", endDate)
        )

        // 4º Ejecutar la consulta
        val noticias = coll.find(filter).toList()

        return noticias
    }


}