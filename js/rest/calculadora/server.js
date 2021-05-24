const express = require("express")
const cors = require("cors")
const rota_soma = require("./operacoes/soma")
const rota_subtracao = require("./operacoes/subtracao")
const rota_multiplicacao = require("./operacoes/multiplicacao")
const rota_divisao = require("./operacoes/divisao")


const app = express()
const porta = 3030

app.use(express.static("./public"))

app.use(cors())
app.use(express.json())
app.use("/soma", rota_soma)
app.use("/subtracao", rota_subtracao)
app.use("/multiplicacao", rota_multiplicacao)
app.use("/divisao", rota_divisao)

app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta} ...`)
})