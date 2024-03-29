package model;

import beans.Carrito;
import beans.CarritoInfo;
import beans.Correo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarritoDAO implements DAO<Carrito,Integer> {

    MotorSQL motosSql;

    public CarritoDAO() {
        this.motosSql = new MotorSQL();

    }

    @Override
    public int add(Carrito bean)  {
        int resp = 0;
        int delete = 0;

        motosSql.conectar();

        String checkCarritoSql = "SELECT COUNT(*) AS count FROM carrito WHERE id_usuario = " + bean.getIdUsuario();
        System.out.println(checkCarritoSql);
        ResultSet checkResult = motosSql.consultar(checkCarritoSql);

        try {
            if (checkResult.next()) {
                int itemCount = checkResult.getInt("count");
                System.out.println(itemCount);

                if (itemCount > 0) {
                    // Hay elementos en el carrito, eliminarlos
                    String deleteCarritoSql = "DELETE FROM carrito WHERE id_usuario = " + bean.getIdUsuario();
                    System.out.println(deleteCarritoSql);
                    delete = motosSql.modificar(deleteCarritoSql);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (checkResult != null) {
                try {
                    checkResult.close();
                } catch (SQLException e) {
                    // Manejar la excepción según tus necesidades
                    e.printStackTrace();
                }
            }
        }

        String sql2 = "SELECT id_compra\n" +
                "FROM compra\n" +
                "WHERE id_usuario = " + bean.getIdUsuario() +
                " AND confirmada = 0;";
        System.out.println(sql2);
        ResultSet rs = motosSql.consultar(sql2);
        try {
            while (rs.next()) {
                Carrito carrito1 = new Carrito(rs.getInt("id_compra"));
                String sql = "INSERT INTO carrito (id_compra, id_usuario, id_obra_sala, cantidad) VALUES (" + carrito1.getIdCompra() + "," + bean.getIdUsuario() + "," + bean.getIdObraSala() + "," + bean.getCantidad() + ")";
                System.out.println(sql);
                resp = motosSql.modificar(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            motosSql.desconectar();
        }

        return resp;
    }


    @Override
    public int delete(Integer e) {
        int resp = 0;



        return resp;
    }

    public int eliminar(Carrito bean) {
        int resp = 0;
        motosSql.conectar();

        // Aquí asumo que la tabla tiene un campo único que identifica cada registro de carrito
        String sql = "DELETE FROM carrito WHERE id_usuario = " + bean.getIdUsuario();

        try {
            resp = motosSql.modificar(sql);
        } catch (Exception e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
        } finally {
            motosSql.desconectar();
        }

        return resp;

    }
    @Override
    public int update(Carrito bean) {
        return 0;
    }

    @Override
    public ArrayList<Carrito> findAll() throws SQLException {
        return null;
    }

    public ArrayList<CarritoInfo> findCarrito(int id_usuario) throws SQLException {

        ArrayList<CarritoInfo> lstCarrito = new ArrayList<>();

        String sql = "SELECT c.id_carrito, o.titulo_obra, o.imagen_obra, o.descripcion_obra," +
                " s.nombre AS nombre_sala, o.duracion_min, os.fecha, os.hora, o.precio, c.cantidad, os.id_obra_sala\n" +
                "FROM carrito c\n" +
                "INNER JOIN obra_sala os ON c.id_obra_sala = os.id_obra_sala\n" +
                "INNER JOIN obra o ON os.id_obra = o.id_obra\n" +
                "INNER JOIN sala s ON os.id_sala = s.id_sala\n" +
                "WHERE c.id_usuario =" + id_usuario;

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);
        try {
            while (rs.next()) {
                CarritoInfo carrito = new CarritoInfo(
                        rs.getInt("id_carrito"),
                        rs.getInt("id_obra_sala"),
                        rs.getString("titulo_obra"),
                        rs.getString("imagen_obra"),
                        rs.getString("nombre_sala"),
                        rs.getInt("duracion_min"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getBigDecimal("precio"),
                        rs.getInt("cantidad")
                );

                lstCarrito.add(carrito);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        motosSql.desconectar();
        return lstCarrito;
    }
    public ArrayList<Carrito> findhistorial(int id_usuario) throws SQLException {

        ArrayList<Carrito> lstcarrito = new ArrayList<>();

        String sql = "SELECT \n" +
                "    c.id_compra,\n" +
                "    c.fecha_compra,\n" +
                "    SUM(o.precio * c.cantidad) AS precio_total\n" +
                "FROM compra c\n" +
                "JOIN obra_sala os ON c.id_obra_sala = os.id_obra_sala\n" +
                "JOIN obra o ON os.id_obra = o.id_obra\n" +
                "WHERE c.id_usuario = "+ id_usuario + " AND c.confirmada = 1 " +
                "GROUP BY c.id_compra, c.fecha_compra;\n";

        System.out.println(sql);
        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);
        try {
            while (rs.next()) {
                Carrito carrito = new Carrito(
                        rs.getInt("id_compra"),
                        rs.getInt("precio_total"),
                        rs.getString("fecha_compra")
                );

                lstcarrito.add(carrito);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        motosSql.desconectar();
        return lstcarrito;
    }
    public int confirmCompra(String id_usuario){
        int respuesta = 0;
        try{
            motosSql.conectar();
            int idCompraActual = 0;
            int totalCantidad = 0;
            String destinatario = "";

            ResultSet rsCompra = motosSql.consultar("SELECT id_compra FROM compra WHERE id_usuario = "+id_usuario+" AND confirmada = 0");
            while(rsCompra.next()){
                idCompraActual = rsCompra.getInt("id_compra");
            }
            // Obtener la cantidad total sumada
            ResultSet rsTotalCantidad = motosSql.consultar("SELECT SUM(o.precio * crt.cantidad) AS total_cantidad " +
                    "FROM compra c " +
                    "JOIN carrito crt ON c.id_compra = crt.id_compra " +
                    "JOIN obra_sala os ON crt.id_obra_sala = os.id_obra_sala " +
                    "JOIN obra o ON os.id_obra = o.id_obra " +
                    "WHERE c.id_usuario = " + id_usuario + " AND c.confirmada = 0");
            //System.out.println(rsTotalCantidad);
            while (rsTotalCantidad.next()) {
                totalCantidad = rsTotalCantidad.getInt("total_cantidad");
            }

            // Modificamos la compra para dejarla confirmada.
            String sql = "UPDATE compra crt " +
                    "JOIN carrito c ON crt.id_compra = c.id_compra " +
                    "SET crt.confirmada = 1, crt.fecha_compra = current_date(), crt.cantidad = "+totalCantidad+", crt.id_obra_sala = c.id_obra_sala " +
                    "WHERE crt.id_usuario = "+id_usuario+" AND crt.confirmada = 0";

            System.out.println(sql);
            respuesta += motosSql.modificar(sql);

            //Añadimos al usuario la nueva compra.
            respuesta += motosSql.modificar("INSERT INTO compra(id_usuario, confirmada) VALUES ("+id_usuario+", 0)");

            respuesta+= motosSql.modificar("DELETE FROM carrito\n" +
                    "WHERE id_usuario = " + id_usuario);

            ResultSet rsCorreo = motosSql.consultar("SELECT email FROM usuario WHERE id_usuario = "+id_usuario);
            while(rsCorreo.next()){
                destinatario = rsCorreo.getString("email");
            }
            //Creamos un nuevo enviador para enviar el correo.
            System.out.println("Enviar un correo a "+destinatario+" del pedido "+idCompraActual);
            Correo enviador = new Correo();
            enviador.createEmail(destinatario, idCompraActual);
            enviador.sendEmail();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            motosSql.desconectar();
        }
        System.out.println("Han sido modificadas " + respuesta + " lineas.");
        return respuesta;
    }
}
