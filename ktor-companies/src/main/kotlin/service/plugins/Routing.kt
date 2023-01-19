package service.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import service.data.Companies
import java.io.File

private const val COMPANIES_FILE = "./src/main/resources/companies.json"

fun Application.configureRouting() {
    routing {
        get("/company") {
            val companies = Json.decodeFromString<Companies>(
                File(COMPANIES_FILE)
                    .inputStream()
                    .readBytes()
                    .toString(Charsets.UTF_8)
            )

            val company = companies.companiesList
                .random()
                .copy(
                    host = this.context.request.local.host
                )

            call.respond(company)
        }
    }
}
