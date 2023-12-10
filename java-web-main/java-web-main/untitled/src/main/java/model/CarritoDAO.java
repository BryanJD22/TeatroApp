package model;

import beans.Carrito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Carrito> findCarrito(int id_usuario) throws SQLException {
        return null;
    }
}
