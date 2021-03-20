package com.example

import com.example.models.Person
import com.example.repo.PersonRepo
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    val personRepo = PersonRepo()

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
        get("/perons") {
            call.respond(personRepo.getAllPersons())
        }
        get("/person/{id}") {
            val id = call.parameters["id"]
            id?.let {
                call.respond(personRepo.getPerson(id))
            }

        }

        post {
            val person=call.receive<Person>()
            personRepo.insertPerson(person)
        }
    }
}


