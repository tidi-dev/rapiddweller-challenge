package daiho.codechallenge.rapiddweller.exception

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@Component
@RestControllerAdvice
class BadRequestException {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun processValidationError(ex: InvalidException): Any {
        val errors = mutableMapOf<String, MutableList<String>>()
        ex.errors?.fieldErrors?.forEach {
            if (errors.containsKey(it.field))
                it.defaultMessage?.let { it1 -> errors[it.field]!!.add(it1) }
            else
                errors[it.field] = it.defaultMessage?.let { it1 -> mutableListOf(it1) }!!
        }
        return mapOf("errors" to errors)
    }
}

data class InvalidException(val errors: Errors?) : RuntimeException()

object InvalidRequest {
    fun check(errors: Errors) {
        if (errors.hasFieldErrors())
            throw InvalidException(errors)
    }
}
