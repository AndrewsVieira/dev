const express = require('express')
const cors = require('cors')
const connect = require('./database/connect')

const port = 4444

const app = express()
app.use(cors())
app.use('/bookstore', connect)
app.use(express.static('public'))

app.listen(port, () => {
    console.log("Servidor rodando na porta", port)
})