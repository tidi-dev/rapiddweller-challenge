package daiho.codechallenge.rapiddweller.controller

import daiho.codechallenge.rapiddweller.dto.InterpreterRequestDto
import daiho.codechallenge.rapiddweller.service.InterpreterResponse
import daiho.codechallenge.rapiddweller.service.InterpreterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/interpreter")
class InterpreterController(val interpreterService: InterpreterService) {
    @PostMapping
    fun interpret(@RequestBody interpreterRequestDto: InterpreterRequestDto): ResponseEntity<InterpreterResponse> {
        if (interpreterRequestDto.input.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(InterpreterResponse("Input must not be empty"))
        }

        return interpreterService.interpret(interpreterRequestDto.input.replace(" val ", "\nval "))
    }
}