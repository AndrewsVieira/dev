const WebSocket = require('ws')

const wss = new WebSocket.Server({
    host: 'localhost', port: 8080
})

wss.on('connection', ws => {
    ws.on('message', mensagem => {
        let eco = `Mensagem recebida: ${mensagem}`
        console.log(eco)
        ws.send(eco)
    })
    ws.send('Estou te ouvindo!')
})

console.log('Servidor rodando...')