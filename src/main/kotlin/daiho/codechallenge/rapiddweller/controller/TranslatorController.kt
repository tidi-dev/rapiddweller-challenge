package daiho.codechallenge.rapiddweller.controller

import daiho.codechallenge.rapiddweller.service.TranslatorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/translator")
class TranslatorController(val translatorService: TranslatorService) {
    @PostMapping
    fun translateText(@RequestBody requestBody: Map<String, String>): Any {
        val textToTranslate = requestBody["text"] ?: throw IllegalArgumentException("Text to translate not provided")

        return translatorService.translate(textToTranslate)
    }
}