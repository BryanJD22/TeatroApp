package action;

import beans.Obra;
import model.ObraDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class  ObraAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                pagDestino = findAll(request, response);
                break;
            case "ADD":
                pagDestino = addObra(request, response);
                break;
            case "FINDBY_IDSALA":
                pagDestino = findbyidSala(request, response);
                break;
            case "TOP10VENTAS":
                pagDestino = top10Ventas(request, response);
                break;

            case "TOP10PUNTUADAS":
                pagDestino = top10Puntuas(request, response);
                break;

            case "BYCATEGORIA":
                pagDestino = porCategoria(request, response);
                break;

            case "FINDBY_ID":
                pagDestino = findbyid(request,response);
                break;
        }
        return pagDestino;
    }

    private String findbyid(HttpServletRequest request, HttpServletResponse response) {
        String idobra = request.getParameter("IDOBRA");
        ArrayList<Obra> obraById = new ObraDAO().findIdObra(Integer.parseInt(idobra));
        return Obra.toArrayJson(obraById);
    }

    private String porCategoria(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String categoria = request.getParameter("CATEGORIA");
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> lstporCategoria = obraDAO.porCategoria(categoria);

        return Obra.toArrayJson(lstporCategoria);
    }

    private String findbyidSala(HttpServletRequest request, HttpServletResponse response) {
        String idSala = request.getParameter("IDSALA");

        if (idSala != null && !idSala.isEmpty()) {
            ArrayList<Obra> obrasBySala = new ObraDAO().findObrasBySala(Integer.parseInt(idSala));

            return Obra.toArrayJson(obrasBySala);
        } else {

            return "{'error': 'Missing or empty IDSALA parameter'}";
        }
    }

    private String top10Puntuas(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> top10Puntuadas = obraDAO.Top10Puntuadas();

        return Obra.toArrayJson(top10Puntuadas);
    }

    private String top10Ventas(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> top10Ventas = obraDAO.Top10Ventas();
        return Obra.toArrayJson(top10Ventas);

    }



    private String addObra(HttpServletRequest request, HttpServletResponse response) {
        ObraDAO obraDAO = new ObraDAO();
        String tituloObra = request.getParameter("TITULO");
        //String categoria = request.getParameter("CATEGORIA");
        String desc = request.getParameter("DESC");
        String duracion = request.getParameter("DURACION");
        //String img = request.getParameter("IMG");
        String precio = request.getParameter("PRECIO");
        System.out.println("Título recibido: " + tituloObra);
        System.out.println("Descripción recibida: " + desc);
        System.out.println("Duración recibida: " + duracion);
        System.out.println("Precio recibido: " + precio);
        BigDecimal precioObra = new BigDecimal(precio);
        Obra obra = new Obra(tituloObra,desc, Integer.parseInt(duracion),precioObra);
        int respuesta = obraDAO.add(obra);
        Obra obra1 = new Obra(respuesta);
        ArrayList<Obra> obras = new ArrayList<>();
        obras.add(obra1);

        return Obra.toArrayJson(obras);

    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ObraDAO obraDAO = new ObraDAO();
        ArrayList<Obra> obras = obraDAO.findAll();
        System.out.println(obras);
        return Obra.toArrayJson(obras);

    }
}
