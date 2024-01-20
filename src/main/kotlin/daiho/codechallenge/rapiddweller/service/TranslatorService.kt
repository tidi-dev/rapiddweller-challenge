package daiho.codechallenge.rapiddweller.service

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service

@Service
class TranslatorService {
    private val rapidUrl = "https://translated-mymemory---translation-memory.p.rapidapi.com/get?langpair=en|de&q="
    private val rapidApiKey = "replace your key"
    private val rapidApiHost = "translated-mymemory---translation-memory.p.rapidapi.com"
    private val client = OkHttpClient()

    fun translate(textToTranslate: String): String {
        val request = Request.Builder()
            .url("$rapidUrl$textToTranslate")
            .get()
            .addHeader("X-RapidAPI-Key", rapidApiKey)
            .addHeader("X-RapidAPI-Host", rapidApiHost)
            .build()

        client.newCall(request).execute().use { return it.body?.string() ?: "Empty response" }
    }
}