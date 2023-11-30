package action;

import beans.Valoracion;
import model.ValorarDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValorarAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "ADDVALORACION":
                pagDestino = valorar(request, response);
                break;
            case"VALORACIONOBRA":
                pagDestino = valoracionObra(request, response);
                break;



        }
        return pagDestino;
    }

    private String valoracionObra(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ValorarDAO valorarDAO = new ValorarDAO();
        int id_obra = Integer.parseInt(request.getParameter("IDOBRA"));
        Valoracion valoracion = new Valoracion(id_obra);

        ArrayList<Valoracion> valoracionObra1 = new ValorarDAO().valoracionObra(valoracion);
        System.out.println(Valoracion.toArrayJson(valoracionObra1));
        return Valoracion.toArrayJson(valoracionObra1);
    }


    private String valorar(HttpServletRequest request, HttpServletResponse response) {
        ValorarDAO valorarDAO = new ValorarDAO();
        double valoracion = Double.parseDouble(request.getParameter("VALORACION"));
        int id_obra = Integer.parseInt(request.getParameter("IDOBRA"));
        int id_user = Integer.parseInt(request.getParameter("IDUSER"));
        Valoracion valoracion1 = new Valoracion(valoracion,id_obra,id_user);

        int resp = valorarDAO.add(valoracion1);
        return "{\"lineas_afectadas\":"+resp+"}";


    }
}
