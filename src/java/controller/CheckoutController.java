package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Carrinho;
import model.bean.Produtos;
import model.dao.ProdutosDAO;

@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obter os itens do carrinho a partir da sessão
            List<Produtos> itens = Carrinho.getItens(request);
            request.setAttribute("itens", itens);

            String nextPage = "/WEB-INF/jsp/finalizarCompra.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao processar o carrinho", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idProduto = Integer.parseInt(request.getParameter("id"));
            // Suponha que você tenha uma maneira de obter um produto pelo ID
            Produtos produto = obterProdutoPeloId(idProduto);

            Carrinho.adicionarItem(request, produto);
            response.getWriter().write("Produto adicionado ao carrinho");
        } catch (Exception e) {
            throw new ServletException("Erro ao adicionar produto ao carrinho", e);
        }
    }

    private Produtos obterProdutoPeloId(int id) {
        // Lógica para obter o produto pelo ID
        // Exemplo: return produtoDAO.obterProdutoPeloId(id);
        ProdutosDAO pDao = new ProdutosDAO();
        Produtos produto = pDao.buscarProduto(id);
        return produto;
    }
}
