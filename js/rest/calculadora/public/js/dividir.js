const btnDividir = document.getElementById("dividir")
if (btnDividir) {
    btnDividir.addEventListener("click", () => {
        const div = document.querySelector('.divisao')
        const a = div.querySelector('#A').value
        const b = div.querySelector('#B').value
        const tRes = div.querySelector('#res')

        let url = `/divisao/?a=${a}&b=${b}`
        let erro

        fetch(url, {
            method: "GET",
        }).then((res) => {
            if(res.status == 200) {
                res.json().then((obj) => {
                    let res = obj.Resultado
                    tRes.innerHTML = `<p>Resuldado: ${res}</p>`
                })
            } else {
                res.json().then((obj) => {
                    let erro = ""
                    obj.erro.forEach(element => {
                        erro += `${element.msg}\n`
                    });
                    alert(erro)
                })
            }
        }).catch((err) => {
            console.log(err)
        })
    })
} else {
    console.log(`Não foi possível achar o botão somar [btnSomar]: [${btnDividir}]`)
}