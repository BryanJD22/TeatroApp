package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CarritoAction implements IAction{
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

        }
        return pagDestino;
    }

    private String addObra(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
