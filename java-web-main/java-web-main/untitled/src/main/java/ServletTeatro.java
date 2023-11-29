import action.*;
import beans.Categoria;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletTeatro", urlPatterns = {"/ServletTeatro"})
public class ServletTeatro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[0]) {
            case "User":
                try {
                    out.print(new UserAction().
                            execute(request, response));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Obra":
                try {
                    out.print(new ObraAction().execute(request,response));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Sala":
                try {
                    out.print(new SalaAction().execute(request,response));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Categoria":
                try {
                    out.print(new CategoriaAction().execute(request,response));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Valorar":
                try {
                    out.print(new ValorarAction().execute(request,response));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }


    }



       /* public static String convertUsersToJSONString(List<User> users) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"username\": \"").append(user.getUsername()).append("\", ");
            jsonBuilder.append("\"Email\": \"").append(user.getEmail()).append("\"");
            jsonBuilder.append("\"Pass\": \"").append(user.getPass()).append("\"");
            jsonBuilder.append("}");

            // Si no es el último elemento, añade una coma
            if (i < users.size() - 1) {
                jsonBuilder.append(", ");
            }
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }*/
}

