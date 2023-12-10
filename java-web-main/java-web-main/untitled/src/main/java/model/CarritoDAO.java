package model;

import beans.Carrito;
import beans.CarritoInfo;

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
    public int add(Carrito bean) {
        int resp=0;
        motosSql.conectar();
        String sql = "INSERT INTO carrito (id_usuario, id_obra_sala, cantidad) VALUES ("+bean.getIdUsuario()+","+ bean.getIdObraSala()+","+ bean.getCantidad()+")";
        System.out.println(sql);
         resp = motosSql.modificar(sql);


        motosSql.desconectar();

        return resp;
    }

    @Override
    public int delete(Integer e) {
        return 0;
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

        String sql = "SELECT c.id_carrito, o.titulo_obra, o.imagen_obra, o.descripcion_obra, s.nombre AS nombre_sala, o.duracion_min, os.fecha, os.hora, o.precio, c.cantidad\n" +
                "FROM carrito c\n" +
                "INNER JOIN obra_sala os ON c.id_obra_sala = os.id_obra_sala\n" +
                "INNER JOIN obra o ON os.id_obra = o.id_obra\n" +
                "INNER JOIN sala s ON os.id_sala = s.id_sala\n" +
                "WHERE c.id_usuario ="+id_usuario;

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);
        try {
            while (rs.next()) {
                CarritoInfo carrito = new CarritoInfo(
                        rs.getInt("id_carrito"),
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
}
