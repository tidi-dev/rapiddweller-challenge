package daiho.codechallenge.rapiddweller.service

import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import com.google.cloud.translate.Translation
import daiho.codechallenge.rapiddweller.dto.TranslatorRequestDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

data class TranslationResponse(
    val translatedText: String
)

@Service
class TranslatorService {
    private val translate: Translate = TranslateOptions.newBuilder()
        .setApiKey("REPLACE_YOUR_API_KEY")
        .build()
        .service

    fun translate(translatorRequestDto: TranslatorRequestDto): ResponseEntity<TranslationResponse> {
        val translation: Translation = translate.translate(
            translatorRequestDto.text,
            Translate.TranslateOption.targetLanguage(translatorRequestDto.targetLanguage)
        )

        val response = TranslationResponse(translation.translatedText)
        return ResponseEntity.ok(response)
    }
}