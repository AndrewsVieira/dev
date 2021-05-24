const operacao = require('express').Router()
const { check, body, validationResult } = require('express-validator')
const soap = require("soap")

const wsdl = 'http://www.dneonline.com/calculator.asmx?wsdl'

operacao.get('/', [
    check('a', "'a' é parâmetro obrigatório").trim().escape().notEmpty().isInt().withMessage("Parâmetro 'a' não é número").toInt(),
    check('b', "'b' é parâmetro obrigatório").trim().escape().notEmpty().isInt().withMessage("Parâmetro 'b' não é número").toInt()
], (req, res) => {

    const erros = validationResult(req);
    let erroValidator = erros.array()
    console.log(erroValidator)

    const a = req.query.a
    const b = req.query.b
    console.log(`a: ${a}, b: ${b}`)
    let erro

    if (!erros.isEmpty()) {
        erro = { erro: erroValidator }
        return res.status(422).json(erro)
    } else {
        soap.createClient(wsdl, (err, cli) => {
            if (err) {
                console.log("erro  ao criar cliente\n")
                erro = { erro: "Ocorreu um erro na aplicação." }
                return res.status(422).json(erro)
            } else {
                cli.Add({ intA: `${a}`, intB: `${b}` }, (err, result) => {
                    if (err) {
                        console.log("Erro ao efetuar o cálculo\n")
                        erro = { erro: "Ocorreu um erro ao efetuar o cálculo." }
                        return res.status(422).json(erro)
                    } else {
                        let retorno = { "Resultado": result.AddResult }
                        return res.status(200).json(retorno)
                    }
                })
            }
        })
    }
})

module.exports = operacao