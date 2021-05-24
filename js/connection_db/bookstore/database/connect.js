const connect = require('express').Router()
const knex = require('knex')
require('dotenv').config()

const conn = knex({
    client: 'mysql2',
    connection: {
        host: process.env.HOST,
        user: process.env.USUARIO,
        password: process.env.SENHA,
        database: process.env.BANCODEDADOS
    }
})

connect.get('/', (req, res) => {
    let erro

    conn.select( 'book.title', 'book.year','book.price','author.first_name','author.last_name',)
        .table('book')
        .innerJoin('author','book.id_author', '=','author.id')
        .orderBy('book.year')
        .then(livros => {
            res.status(200).json(livros)
        }).catch(err => {
            erro = '{ERRO: "Ocorreu um erro interno. Por favor tente novamente mais tarde."'
            console.error(err)
            res.status(500), json(erro)
        })
})

module.exports = connect