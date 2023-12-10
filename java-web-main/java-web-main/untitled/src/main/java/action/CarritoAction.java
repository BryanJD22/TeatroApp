package action;

import beans.Carrito;
import beans.CarritoInfo;
import model.CarritoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarritoAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_CARRITO":
                pagDestino = findCarrito(request, response);
                break;
            case "ADD":
                pagDestino = addObra(request, response);
                break;
            case "HISTORIAL_CARRITO":
                pagDestino = historial(request, response);
                break;
            case "CONFIRMAR":
                pagDestino = confirmar(request,response);
                break;

        }
        return pagDestino;
    }

    private String confirmar(HttpServletRequest request, HttpServletResponse response) {
        String id_user = request.getParameter("IDUSER");
        CarritoDAO carritoDAO = new CarritoDAO();

        int resp = carritoDAO.confirmCompra(id_user);
        return "{\"lineas_afectadas\":"+resp+"}";
    }

    private String historial(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String iduser = request.getParameter("IDUSER");
        CarritoDAO carritoDAO = new CarritoDAO();
        ArrayList<Carrito> lstHistorial= carritoDAO.findhistorial(Integer.parseInt(iduser));
        System.out.println(Carrito.toArrayJson(lstHistorial));
        return Carrito.toArrayJson(lstHistorial);
    }

    private String findCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idUser = request.getParameter("IDUSER");
        CarritoDAO carritoDAO = new CarritoDAO();

        ArrayList<CarritoInfo> carritoInfos = carritoDAO.findCarrito(Integer.parseInt(idUser));
        System.out.println(CarritoInfo.toArrayJson(carritoInfos));
        return CarritoInfo.toArrayJson(carritoInfos);
    }

    private String addObra(HttpServletRequest request, HttpServletResponse response) {
        CarritoDAO carritoDAO = new CarritoDAO();

        try {
            // Obtener parámetros del formulario
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int idObraSala = Integer.parseInt(request.getParameter("ID_OBRA_SALA"));
            int cantidad = Integer.parseInt(request.getParameter("CANTIDAD"));

            // Crear instancia de Carrito
            Carrito carrito = new Carrito(idUsuario, idObraSala, cantidad);

            // Llamar al método add en el DAO
            int respuesta = carritoDAO.add(carrito);

            if (respuesta > 0) {
                // Éxito al agregar al carrito
                return "Carrito actualizado con éxito";
            } else {
                // Error al agregar al carrito
                return "Error al agregar al carrito";
            }
        } catch (NumberFormatException e) {
            // Manejar error de conversión de números
            e.printStackTrace();
            return "Error en el formato de los parámetros";
        }
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
