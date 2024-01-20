package daiho.codechallenge.rapiddweller.dto

data class TranslatorRequestDto(
    val text: String = "",
    val targetLanguage: String = "de"
)
