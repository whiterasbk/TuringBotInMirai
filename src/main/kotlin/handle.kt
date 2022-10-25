package bot.turingapi.whiter

import bot.turingapi.whiter.data.request.RequestForm
import bot.turingapi.whiter.data.response.ResponseForm
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

val client by lazy {
    HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
    }
}

suspend fun request(buildBody: () -> RequestForm): ResponseForm = client.post {
    url("http://openapi.turingapi.com/openapi/api/v2")
    contentType(ContentType.Application.Json)
    setBody(buildBody().apply {
        userInfo.apiKey = BotConfiguration.appKey
    })
}.bodyAsText().let {
    Json.decodeFromString(it)
}
