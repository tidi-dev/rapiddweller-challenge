package daiho.codechallenge.rapiddweller.controller

import daiho.codechallenge.rapiddweller.dto.TranslatorRequestDto
import daiho.codechallenge.rapiddweller.service.TranslationResponse
import daiho.codechallenge.rapiddweller.service.TranslatorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/translator")
class TranslatorController(val translatorService: TranslatorService) {
    @PostMapping
    fun translateText(@RequestBody translatorRequestDto: TranslatorRequestDto): Any {
        if (translatorRequestDto.text.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(TranslationResponse("Text must not be empty"))
        }

        return translatorService.translate(translatorRequestDto)
    }

}