package daiho.codechallenge.rapiddweller.service

import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import com.google.cloud.translate.Translation
import daiho.codechallenge.rapiddweller.dto.TranslatorRequestDto
import io.github.cdimascio.dotenv.Dotenv
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

data class TranslationResponse(
    val translatedText: String
)

@Service
class TranslatorService(private final val dotenv: Dotenv) {
    private val translate: Translate = TranslateOptions.newBuilder()
        .setApiKey(dotenv["API_KEY"])
        .build()
        .service

    fun translate(translatorRequestDto: TranslatorRequestDto): ResponseEntity<TranslationResponse> {
        val translation: Translation = translate.translate(
            translatorRequestDto.text,
            Translate.TranslateOption.targetLanguage(translatorRequestDto.targetLanguage)
        )
        return ResponseEntity.ok(TranslationResponse(translation.translatedText))
    }
}