<%-- 
    Document   : finalizarCompra
    Created on : 18/06/2024, 12:15:18
    Author     : Iago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.bean.Produtos"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar Compra</title>
        <style>
            .produto {
                display: flex;
                border: 1px solid #ccc;
                padding: 10px;
                margin-bottom: 10px;
            }
            .container-img img {
                width: 100px;
                height: auto;
            }
            .container-infos {
                margin-left: 20px;
            }
            .container-infos p {
                margin: 5px 0;
            }
            .preco {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <h1>Finalizar Compra</h1>

        <div id="etapa-01-revisao">
            <%
                // Obter a lista de itens do carrinho
                List<Produtos> itens = (List<Produtos>) request.getAttribute("itens");

                // Verificar se o carrinho está vazio
                if (itens == null || itens.isEmpty()) {
            %>
                <p>Seu carrinho está vazio.</p>
            <%
                } else {
                    // Iterar sobre os itens do carrinho e exibir as informações dos produtos
                    for (Produtos produto : itens) {
            %>
                <div class="produto">
                    <div class="container-img">
                        <img src="<%= produto.getImagem() %>" alt="<%= produto.getNome() %>">
                    </div>
                    <div class="container-infos">
                        <p><%= produto.getNome() %></p>
                        <p class="preco">R$ <%= String.format("%.2f", produto.getValor()) %></p>
                        <p><%= produto.getDescricao() %></p>
                    </div>
                </div>
            <%
                    }
                }
            %>
        </div>

        <div id="etapa-02-endereco"> 

        </div>

        <div id="etapa-03-pagamento"> 

        </div>

        <div id="etapa-04-cortesia"> 

        </div>
    </body>
</html>
