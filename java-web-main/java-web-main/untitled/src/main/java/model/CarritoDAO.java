package model;

import beans.Carrito;

import java.sql.SQLException;
import java.util.ArrayList;

public class CarritoDAO implements DAO<Carrito,Integer> {
    @Override
    public int add(Carrito bean) {
        return 0;
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
