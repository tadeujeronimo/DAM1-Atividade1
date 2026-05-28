open class Marciano {
    open fun responde(frase: String): String {
        val mensagem = frase.trim()

        if (mensagem.isEmpty()) {
            return "Não me incomode"
        }

        return when {
            ehPergunta(mensagem) && ehGritando(mensagem) -> "Relaxa, eu sei o que estou fazendo!"
            ehPergunta(mensagem) -> "Certamente"
            ehGritando(mensagem) -> "Opa! Calma aí!"
            contemEu(mensagem) -> "A responsabilidade é sua"
            else -> "Tudo bem, como quiser"
        }
    }

    fun responda(frase: String): String {
        return responde(frase)
    }

    protected fun ehPergunta(texto: String): Boolean {
        return texto.endsWith("?")
    }

    protected fun ehGritando(texto: String): Boolean {
        val palavras = texto.split(Regex("\\s+")).filter { it.isNotBlank() }

        return palavras.any { palavra ->
            val letras = palavra.filter(Char::isLetter)
            letras.isNotEmpty() && letras == letras.uppercase()
        }
    }

    protected fun contemEu(texto: String): Boolean {
        return Regex("(?i)\\beu\\b").containsMatchIn(texto)
    }
}
