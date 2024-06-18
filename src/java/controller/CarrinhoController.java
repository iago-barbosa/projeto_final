package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Carrinho;
import model.bean.Produtos;
import model.dao.ProdutosDAO;
import com.google.gson.Gson;
import java.util.List;

@WebServlet(name = "CarrinhoController", urlPatterns = {"/carrinho"})
public class CarrinhoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produtos> itens = Carrinho.getItens(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(toJson(itens));
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("id"));
        ProdutosDAO pDao = new ProdutosDAO();
        Produtos item = pDao.buscarProduto(idProduto);
        if (item.getIdProduto() > 0) {
            Carrinho.adicionarItem(request, item);
        }
        List<Produtos> itens = Carrinho.getItens(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(toJson(itens));
        out.flush();
    }

    private String toJson(List<Produtos> itens) {
        Gson gson = new Gson();
        return gson.toJson(itens);
    }
}
