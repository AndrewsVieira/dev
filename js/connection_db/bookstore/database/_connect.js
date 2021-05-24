const connect = require('express').Router()
const Sequelize = require('sequelize')
require('dotenv').config()

const connParams = new Sequelize (
    process.env.BANCODEDADOS,
    process.env.USUARIO,
    process.env.SENHA,
    {
        host: process.env.HOST,
        dialect: 'mysql'
    }
)

const Autor = connParams.define('author', {
    first_name: {
        type: Sequelize.STRING,
        allowNull: false
    },
    last_name: {
        type: Sequelize.STRING,
        allowNull: false
    }    
},{
    freezeTableName: true,
    timestamps: false
})


const Livro = connParams.define('book', {
    title: {
        type: Sequelize.STRING,
        allowNull: false
    },
    year: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    price: {
        type: Sequelize.NUMBER,
        allowNull: false
    },
    id_author: {
        type: Sequelize.INTEGER,
        allowNull: false
    }
}, {
    freezeTableName: true,
    timestamps: false
})

Autor.hasMany(Livro)
Livro.belongsTo(Autor)

connect.get('/', async (req, res) => {
    const livros = await Livro.findAll({ 
        raw: true,
        require: [{ model: Autor}]
    })

    const autores = await livros.getAutor()

    const response = {
        "autores": autores,
        "livros": livros
    }

    res.status(200).json(response)
})

module.exports = connect;