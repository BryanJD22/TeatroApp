package action;

import beans.Obra;
import beans.Sala;
import model.ObraDAO;
import model.SalaDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                pagDestino = findAll(request, response);
                break;
            case "FINDBY_ID":
                pagDestino = fingByID(request, response);
                break;

        }
        return pagDestino;
    }

    private String fingByID(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idsala = request.getParameter("IDSALA");
        ArrayList<Sala> salaById = new SalaDAO().findById(Integer.parseInt(idsala));
        return Sala.toArrayJson(salaById);

    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        SalaDAO salaDAO = new SalaDAO();
        ArrayList<Sala> lstsalas = salaDAO.findAll();
        System.out.println(lstsalas);
        return Sala.toArrayJson(lstsalas);
    }
}
