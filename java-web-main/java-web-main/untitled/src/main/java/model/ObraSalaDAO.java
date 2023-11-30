package model;

import beans.ObraSala;

import java.sql.SQLException;
import java.util.ArrayList;

public class ObraSalaDAO implements DAO<ObraSala, Integer>{

    MotorSQL motorSQL;

    public ObraSalaDAO() {
        this.motorSQL = new MotorSQL();
    }

    @Override
    public int add(ObraSala bean) {
        int resp =0;
        motorSQL.conectar();
        String sql = "INSERT INTO OBRA_SALA(id_obra, id_sala) VALUES (" +
                bean.getIdObra() + ", " +
                bean.getIdSala() + ", '" +
                "')";

        return resp;
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
