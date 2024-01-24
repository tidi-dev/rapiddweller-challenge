package daiho.codechallenge.rapiddweller.service

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.script.ScriptEngineManager

data class InterpreterResponse(
    val output: String
)

@Service
class InterpreterService {
    private val regex = Regex("""\bval\s+(\w+)\s*=""");

    fun interpret(input: String): ResponseEntity<InterpreterResponse> {
        val scriptEngine = ScriptEngineManager().getEngineByExtension("kts")
        val lastVariableName = getLastVariableName(input)

        val script = """
        $input
        $lastVariableName
    """.trimIndent()

        return ResponseEntity.ok(InterpreterResponse("$lastVariableName = ${scriptEngine.eval(script)}"))
    }

    /* uses a regular expression to find the last variable name declared with the val keyword. */
    private fun getLastVariableName(input: String): String? = regex.findAll(input).lastOrNull()?.groupValues?.get(1)
}