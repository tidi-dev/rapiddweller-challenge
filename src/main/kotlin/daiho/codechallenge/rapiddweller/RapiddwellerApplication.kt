package daiho.codechallenge.rapiddweller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RapiddwellerApplication

fun main(args: Array<String>) {
    runApplication<RapiddwellerApplication>(*args)
    println("Kotlin / Java Code Interpreter and Translator Challenge")
}
