package model;

import beans.ObraSala;

import java.sql.SQLException;
import java.util.ArrayList;

public class ObraSalaDAO implements DAO<ObraSala, Integer>{
    @Override
    public int add(ObraSala bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(ObraSala bean) {
        return 0;
    }

    @Override
    public ArrayList<ObraSala> findAll() throws SQLException {
        return null;
    }
}
