const tabela = document.querySelector('.main_table')
console.log(tabela)

const url = './bookstore'

fetch(url, { method: "GET" }).then(res => {
    res.json().then(livros => {
        console.log(livros)
        livros.forEach(livro => {
            let linha = document.createElement('tr')
            tabela.appendChild(linha)
            linha.innerHTML = `<td>${livro.title}</td><td>${livro.price}</td><td>${livro.first_name} ${livro.last_name}</td><td>${livro.year}</td>`            
        });
    })
})
