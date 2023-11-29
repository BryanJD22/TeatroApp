package action;

import beans.Categoria;
import beans.User;
import model.CategoriaDAO;
import model.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                pagDestino = findAll(request, response);
                break;


        }
        return pagDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ArrayList<Categoria> categorias = categoriaDAO.findAll();

        return Categoria.toArrayJson(categorias);
    }
}
