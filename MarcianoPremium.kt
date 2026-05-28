import kotlin.math.pow
import kotlin.math.sqrt

class MarcianoPremium(
    private val acaoPersonalizada: AcaoPersonalizada
) : MarcianoMatematico() {
    override fun responde(frase: String): String {
        if (frase.trim().equals("agir", ignoreCase = true)) {
            return acaoPersonalizada.executar()
        }

        return super.responde(frase)
    }

    override fun responde(operacao: String, vararg operandos: Double): String {
        // Validações e cálculo das operações premium
        val op = operacao.lowercase()

        when (op) {
            "raiz" -> {
                if (operandos.size != 1) return "Preciso de exatamente um número para raiz."
                val x = operandos.first()
                if (x < 0.0) return "Não posso calcular a raiz de número negativo."
                val resultado = sqrt(x)
                return "Essa eu sei, ${formataNumero(resultado)}"
            }

            "potencia" -> {
                if (operandos.size != 2) return "Preciso de dois números (base e expoente)."
                val base = operandos[0]
                val expo = operandos[1]
                val resultado = base.pow(expo)
                return "Essa eu sei, ${formataNumero(resultado)}"
            }

            "modulo" -> {
                if (operandos.size != 2) return "Preciso de dois números para módulo."
                val a = operandos[0]
                val b = operandos[1]
                if (b == 0.0) return "Não posso dividir por zero."
                val resultado = a % b
                return "Essa eu sei, ${formataNumero(resultado)}"
            }

            "percentual" -> {
                if (operandos.size != 2) return "Preciso de dois números (valor e percentual)."
                val valor = operandos[0]
                val perc = operandos[1]
                val resultado = valor * perc / 100.0
                return "Essa eu sei, ${formataNumero(resultado)}"
            }
        }

        // Para operações básicas delega para MarcianoMatematico
        return super.responde(op, *operandos)
    }

    override fun responda(operacao: String, vararg operandos: Double): String {
        return responde(operacao, *operandos)
    }
}
