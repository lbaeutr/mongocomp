package com.es.mongocomp

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongocompApplication

fun main(args: Array<String>) {
	runApplication<MongocompApplication>(*args)
}
