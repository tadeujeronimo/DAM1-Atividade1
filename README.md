# Marciano (Kotlin)

## Descrição

Projeto de robô que responde texto, e faz operações básicas através dos comandos `some`, `subtraia`, `multiplique` `divida` e `agir`, esse último possibilita operações avançadas (`raiz`, `potencia`, `modulo` e `percentual`).

## Estrutura (arquivos principais):

- `AcaoPersonalizada.kt`
- `Marciano.kt`
- `MarcianoMatematico.kt`
- `MarcianoPremium.kt`
- `Main.kt`

## Como compilar (compacto):

```bash
kotlinc *.kt -include-runtime -d Main.jar
```

## Como executar:

```bash
java -jar Main.jar
```

## Principais comandos:

- `some a b ...` — soma
- `subtraia a b ...` — subtração
- `multiplique a b ...` — multiplicação
- `divida a b ...` — divisão
- `agir` — ativa menu com operações avançadas
- `FIM` — encerra

## Vídeo explicativo no YouTube (não listado):

[https://youtu.be/IKMhXCAP9bc](https://youtu.be/IKMhXCAP9bc)

## Autor

- **Nome**: Tadeu dos Santos Jerônimo
- **Matrícula**: 2026202194
- **E-mail**: tadeus.jeronimo@gmail.com
- **Disciplina**: Desenvolvimento de Aplicações Móveis I - IF Sudeste/MG