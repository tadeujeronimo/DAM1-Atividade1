import kotlin.math.pow

fun main() {
    val robo = MarcianoPremium(object : AcaoPersonalizada {
        override fun executar(): String {
            println("Operações avançadas: raiz, potencia, modulo, percentual")
            println("Digite a operação seguida dos operandos separados por espaço (ex: potencia 2 3):")
            val linha = readLine() ?: return "Nenhuma entrada recebida."
            val partes = linha.split(Regex("\\s+"))
            if (partes.isEmpty()) return "Entrada inválida."

            val op = partes.first().lowercase()
            val operandos = partes.drop(1).mapNotNull { it.replace(',', '.').toDoubleOrNull() }

            fun formataNumero(numero: Double): String {
                return if (numero % 1.0 == 0.0) numero.toLong().toString() else numero.toString()
            }

            return when (op) {
                "raiz" -> {
                    if (operandos.size != 1) return "Preciso de exatamente um número para raiz."
                    val x = operandos[0]
                    if (x < 0.0) return "Não posso calcular a raiz de número negativo."
                    "Essa eu sei, ${formataNumero(kotlin.math.sqrt(x))}"
                }
                "potencia" -> {
                    if (operandos.size != 2) return "Preciso de dois números (base e expoente)."
                    val resultado = operandos[0].pow(operandos[1])
                    "Essa eu sei, ${formataNumero(resultado)}"
                }
                "modulo" -> {
                    if (operandos.size != 2) return "Preciso de dois números para módulo."
                    if (operandos[1] == 0.0) return "Não posso dividir por zero."
                    val resultado = operandos[0] % operandos[1]
                    "Essa eu sei, ${formataNumero(resultado)}"
                }
                "percentual" -> {
                    if (operandos.size != 2) return "Preciso de dois números (valor e percentual)."
                    val resultado = operandos[0] * operandos[1] / 100.0
                    "Essa eu sei, ${formataNumero(resultado)}"
                }
                else -> "Operação avançada desconhecida."
            }
        }
    })

    println("Marciano premium pronto.")
    println("Digite uma frase comum, um comando matemático (some, subtraia, multiplique, divida) com números, ou 'agir' para opções premium (operações avançadas).")
    println("Digite FIM para encerrar.")

    while (true) {
        val entrada = readLine() ?: break
        val comando = entrada.trim()

        if (comando.equals("FIM", ignoreCase = true)) {
            break
        }

        if (comando.equals("agir", ignoreCase = true)) {
            println("É pra já!")
            println(robo.responde("agir"))
            continue
        }

        println(interpretaEntrada(robo, comando))
    }
}

private fun interpretaEntrada(robo: MarcianoPremium, entrada: String): String {
    if (entrada.isBlank()) {
        return robo.responde(entrada)
    }

    val partes = entrada.split(Regex("\\s+"))
    val comando = partes.first().lowercase()
    val operacoes = setOf("some", "subtraia", "multiplique", "divida")

    if (comando !in operacoes) {
        return robo.responde(entrada)
    }

    val operandos = partes.drop(1).mapNotNull { it.replace(',', '.').toDoubleOrNull() }
    if (operandos.size != partes.size - 1) {
        return "Número inválido para operação matemática."
    }

    return robo.responde(comando, *operandos.toDoubleArray())
}
