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
            case "FECHASBY_IDOBRA":
                pagDestino = getFechas(request, response);
                break;


        }
        return pagDestino;
    }

    private String getFechas(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idObra = request.getParameter("IDOBRA");
        ArrayList<ObraSala> obraSalas = new ArrayList<>();
        ObraSalaDAO obraSalaDAO = new ObraSalaDAO();
        obraSalas = obraSalaDAO.getFechas(Integer.parseInt(idObra));

        return ObraSala.toArrayJson(obraSalas);
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        ObraSalaDAO obraSalaDAO = new ObraSalaDAO();
        String idObra = request.getParameter("IDOBRA");
        String idSala = request.getParameter("IDSALA");
        ObraSala obraSala = new ObraSala(Integer.parseInt(idObra),Integer.parseInt(idSala));
        int resp = obraSalaDAO.add(obraSala);
        return "{\"Lineas afectadas\":"+resp+"}";

    }



}
