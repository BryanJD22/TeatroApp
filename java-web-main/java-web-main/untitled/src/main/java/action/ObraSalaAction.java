package action;

import beans.ObraSala;
import model.ObraSalaDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObraSalaAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "ADD":
                pagDestino = add(request, response);
                break;



        }
        return pagDestino;
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        ObraSalaDAO obraSalaDAO = new ObraSalaDAO();
        String idSala = request.getParameter("IDSALA");
        String idObra = request.getParameter("IDOBRA");

        ObraSala obraSala = new ObraSala(Integer.parseInt(idObra),Integer.parseInt(idSala));


        return null;

    }
}
