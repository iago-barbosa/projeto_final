<%-- 
    Document   : cadastrarProduto
    Created on : 01/05/2024, 10:49:52
    Author     : Iago
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Cadastro de Produto</h2>
        <form action="cadastrarProduto" id="cadastrarProduto" method="POST" enctype="multipart/form-data">
          <div class="mb-3">
            <label for="nome" class="form-label">Nome do Produto:</label>
            <input type="text" class="form-control" id="nome" name="nome">
          </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="1">Placas-mãe</option>
                    <option value="2">Processadores</option>
                    <option value="3">Memórias RAM</option>
                    <option value="4">Placas de Vídeo</option>
                    <option value="5">Fontes de Alimentação</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição:</label>
                <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
              </div>
            <div class="mb-3">
            <label for="valor" class="form-label">Valor:</label>
            <input type="number" class="form-control" id="valor" name="valor">
          </div>
            <div class="mb-3">
  <label for="imagem" class="form-label">Default file input example</label>
  <input class="form-control" type="file" id="imagem" name="imagem">
</div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
  </body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="./js/cadastrarProduto.js"></script>
</html>

