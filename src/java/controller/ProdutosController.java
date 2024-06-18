/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.Produtos;
import model.dao.ProdutosDAO;
import javax.servlet.annotation.MultipartConfig;
import model.bean.Categorias;
import model.dao.CategoriasDAO;

/**
 * Servlet responsável por controlar as requisições relacionadas aos produtos.
 * Este servlet é configurado para suportar operações de upload de arquivos.
 * 
 * @author Iago
 */
// MultipartConfig é necessário para pegar valores que foram passados com o enctype="multipart/data"
@MultipartConfig
// Esse controller não utilizou Spring MVC, por isso precisamos configurar as páginas desse controller no arquivo web.xml
public class ProdutosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Inicializações dos DAOs
        ProdutosDAO produtosDAO = new ProdutosDAO();
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        
        // Lista todas as categorias disponíveis e as atribui ao atributo "categorias" da requisição
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
        // Obtém a URL da requisição
        String url = request.getServletPath();
        
        // Roteamento de acordo com a URL da requisição
        if(url.equals("/cadastrar-produto")) {
            // Encaminha a requisição para a página de cadastro de produto
            String nextPage = "/WEB-INF/jsp/cadastrarProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if(url.equals("/home")){
            // Lista todos os produtos e encaminha a requisição para a página inicial
            List<Produtos> produtos = produtosDAO.listarProdutos();
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String nextPage = "/WEB-INF/jsp/produtos.jsp";
            int categoriaAtual = request.getParameter("cat") != null ? Integer.parseInt(request.getParameter("cat")) : 0;
            String buscaAtual = request.getParameter("busca") != null ? "%"+request.getParameter("busca")+"%" : "";
            if(categoriaAtual > 0) {
                List<Produtos> produtos = produtosDAO.buscaCategoria(categoriaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            } else {
                List<Produtos> produtos = produtosDAO.buscaProdutos(buscaAtual);
                request.setAttribute("produtos", produtos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cria um novo objeto de Produto com os parâmetros fornecidos na requisição
        Produtos newProduto = new Produtos();
        newProduto.setNome(request.getParameter("nome"));
        newProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));

        // Obtém a parte do arquivo de imagem da requisição
        Part filePart = request.getPart("imagem");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Corrige problemas com o navegador IE
        if (fileName != null && !fileName.isEmpty()) {
            // Se um arquivo de imagem foi enviado, salva-o no diretório de assets
            String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
            File uploads = new File(basePath);
            if (!uploads.exists()) {
                uploads.mkdirs(); // Cria o diretório se não existir
            }
            File file = new File(uploads, fileName);

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace(); // Trate as exceções de forma adequada
            }

            // Configura o caminho relativo da imagem no banco de dados
            newProduto.setImagem("assets/" + fileName);
        } else {
            newProduto.setImagem(null);
        }

        // Salva o produto com o caminho da imagem no banco de dados
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.cadastrarProduto(newProduto);
        response.sendRedirect("./home");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
