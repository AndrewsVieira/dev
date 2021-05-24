const express = require('express')
const cors = require('cors')
const si = require('systeminformation')


app = express()
app.use(cors())
app.use(express.static("./public"))
app.use(express.json())

const porta = 3000

app.get('/eventstream', (req, res) => {
    res.set({
        'Content-Type': 'text/event-stream',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive'
    })
    if (res.status(200)) {
        console.log("EventStream rodando")
        setInterval(() => {
            si.mem().then(dados => {
                console.log(dados)
                res.write(`data: ${JSON.stringify(dados)}\n\n`)
            })
        }, 3000);
    }
})

app.listen(porta, () => {
    console.log(`Servidor rodando na porta ${porta} ...`)
})
