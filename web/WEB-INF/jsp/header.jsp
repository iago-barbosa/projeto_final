<%-- Document : header Created on : 04/05/2024, 09:25:41 Author : Iago --%> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />
    <link rel="stylesheet" href="./styles/header.css" />
  </head>
  <body>
    <header>
      <nav class="navbar navbar-expand-lg navbar-light header-custom">
        <div class="container-custom">
          <a class="navbar-brand" href="./home"
            ><i class="fa-solid fa-house"></i
          ></a>

          <form class="d-flex" action="buscar-produtos" method="get">
            <input
              class="form-control me-2"
              name="busca"
              type="search"
              placeholder="Search"
              aria-label="Search"
            />
            <button class="btn" type="submit">
              <i class="fa-solid fa-magnifying-glass"></i>
            </button>
          </form>
          <div class="profile">
            <i class="fa-solid fa-cart-shopping" id="btn-abrir-carrinho"></i>
            <i class="fa-regular fa-user"></i>
          </div>
        </div>
        <div class="container container-categorias">
          <c:forEach items="${categorias}" var="categoria">
            <div class="categoria">
              <a href="./buscar-produtos?cat=${categoria.idCategoria}&busca="
                >${categoria.nome}</a
              >
            </div>
          </c:forEach>
        </div>
      </nav>
    </header>
    <div id="carrinho">
      <div id="background-carrinho"></div>
      <div id="carrinho-container">
        <div class="carrinho-header">
            <i id="fechar-carrinho" class="fa-solid fa-xmark"></i>
        </div>
        <div id="carrinho-main"></div>
        <div class="carrinho-footer">
            <a href="./checkout"><button class="btn btn-finalizar">FINALIZAR COMPRA</button></a>
        </div>
      </div>
    </div>
  </body>
  <script
    src="https://kit.fontawesome.com/ffe7fbbd06.js"
    crossorigin="anonymous"
  ></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="./js/carrinho.js"></script>
</html>
