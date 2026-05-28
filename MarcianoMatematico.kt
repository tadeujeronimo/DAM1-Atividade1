open class MarcianoMatematico : Marciano() {
    open fun responde(operacao: String, vararg operandos: Double): String {
        if (operandos.size < 2) {
            return "Preciso de pelo menos dois números."
        }

        val resultado = when (operacao.lowercase()) {
            "some" -> operandos.sum()
            "subtraia" -> operandos.drop(1).fold(operandos.first()) { acumulador, valor -> acumulador - valor }
            "multiplique" -> operandos.fold(1.0) { acumulador, valor -> acumulador * valor }
            "divida" -> {
                var acumulador = operandos.first()
                for (valor in operandos.drop(1)) {
                    if (valor == 0.0) return "Não posso dividir por zero."
                    acumulador /= valor
                }
                acumulador
            }
            else -> return super.responde(operacao)
        }

        return "Essa eu sei, ${formataNumero(resultado)}"
    }

    open fun responda(operacao: String, vararg operandos: Double): String {
        return responde(operacao, *operandos)
    }

    protected open fun formataNumero(numero: Double): String {
        return if (numero % 1.0 == 0.0) {
            numero.toLong().toString()
        } else {
            numero.toString()
        }
    }
}
