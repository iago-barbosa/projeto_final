package model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Carrinho {
    private static final String SESSION_ATTR = "carrinho";

    public static void adicionarItem(HttpServletRequest request, Produtos produto) {
        List<Produtos> itens = getItensFromSession(request);
        itens.add(produto);
        saveItensToSession(request, itens);
    }

    public static void removerItem(HttpServletRequest request, int index) {
        List<Produtos> itens = getItensFromSession(request);
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
        }
        saveItensToSession(request, itens);
    }

    public static List<Produtos> getItens(HttpServletRequest request) {
        return getItensFromSession(request);
    }

    public static float calcularTotal(HttpServletRequest request) {
        List<Produtos> itens = getItensFromSession(request);
        float total = 0;
        for (Produtos produto : itens) {
            total += produto.getValor();
        }
        return total;
    }

    private static List<Produtos> getItensFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Produtos> itens = (List<Produtos>) session.getAttribute(SESSION_ATTR);
        if (itens == null) {
            itens = new ArrayList<>();
            session.setAttribute(SESSION_ATTR, itens);
        }
        return itens;
    }

    private static void saveItensToSession(HttpServletRequest request, List<Produtos> itens) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ATTR, itens);
    }
}
