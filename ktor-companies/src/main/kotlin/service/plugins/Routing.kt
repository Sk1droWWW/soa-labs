package service.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import service.data.Companies

fun Application.configureRouting() {
    routing {
        get("/company") {
            val companies = Companies.getList()

            val company = companies.companiesList
                .random()
                .copy(
                    host = this.context.request.local.localHost
                )

            call.respond(company)
        }
    }
}
