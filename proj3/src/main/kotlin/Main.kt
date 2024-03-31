import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun sendMessageToDiscord() {

    val client = HttpClient(CIO)

    val payload = """
    {
        "content": "message"
    }
""".trimIndent()

    val url = ""
    val token = ""

    val response: HttpResponse = client.post(url) {
        headers {
            append(HttpHeaders.Authorization, token)
            append(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        setBody(payload)
    }

    println("Response status: ${response.status}")
    client.close()
}

suspend fun main() {
    sendMessageToDiscord()
}