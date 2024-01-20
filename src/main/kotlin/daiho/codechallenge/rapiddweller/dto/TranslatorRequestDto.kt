package daiho.codechallenge.rapiddweller.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class TranslatorRequestDto(
    @NotEmpty(message = "The input is required.")
    @Size(min = 2)
    val input: String
)
