<%-- 
    Document   : produtos
    Created on : 04/05/2024, 10:24:15
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <c:forEach var="produto" items="${produtos}">
                <div class="col-md-4 mb-3">
                    <div class="card card-custom">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="${produto.imagem}" alt="${produto.nome}">
                            </div>
                            <h5 class="card-title">${produto.nome}</h5>
                            <p class="card-text categoria-text">Categoria: ${produto.nomeCategoria}</p>
                            <p class="card-text">Valor: R$ ${produto.valor}</p>
                        </div>
                        
                    </div>
                </div>
            </c:forEach>

        </main>
    </body>
</html>
