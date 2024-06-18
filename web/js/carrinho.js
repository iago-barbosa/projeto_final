document.addEventListener("DOMContentLoaded", function() {
    const abrirCarrinho = document.getElementById("btn-abrir-carrinho");
    const fecharCarrinho = document.getElementById("fechar-carrinho");
    const background = document.getElementById("background-carrinho");
    const carrinho = document.getElementById("carrinho");

    abrirCarrinho.addEventListener("click", function() {
        carrinho.classList.add("aberto");
    });

    function fechar() {
        carrinho.classList.remove("aberto");
    }

    fecharCarrinho.addEventListener("click", fechar);
    background.addEventListener("click", fechar);

    function carregarCarrinho() {
        const request = new XMLHttpRequest();
        request.open("GET", "checkout", true);
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                const data = JSON.parse(request.responseText);
                const carrinho = document.getElementById("carrinho-main");
                carrinho.innerHTML = "";
                data.forEach(item => {
                    const divProduto = document.createElement("div");
                    divProduto.classList.add("produto");

                    const divImg = document.createElement("div");
                    divImg.classList.add("container-img");
                    divImg.innerHTML = '<img src="'+item.imagem+'" alt="'+item.nome+'">';

                    const divInfos = document.createElement("div");
                    divInfos.classList.add("container-infos");
                    divInfos.innerHTML = '<p>'+item.nome+'</p><p class="preco">R$ '+item.valor.toFixed(2)+'</p>';

                    divProduto.appendChild(divImg);
                    divProduto.appendChild(divInfos);
                    carrinho.appendChild(divProduto);
                });
            }
        };
        request.send();
    }

    carregarCarrinho();

    function adicionarItemAoCarrinho(idProduto) {
        const request = new XMLHttpRequest();
        request.open("POST", "checkout", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                carregarCarrinho();
            }
        };
        request.send("id=" + idProduto);
    }

    const btns = document.getElementsByClassName("btn-comprar");
    for(let i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
            const idProduto = this.getAttribute("data-idproduto");
            adicionarItemAoCarrinho(idProduto);
        });
    }
});
