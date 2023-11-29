package model;

import beans.Obra;
import beans.Sala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaDAO implements DAO<Sala, Integer>{
    MotorSQL motosSql;

    public SalaDAO() {
        this.motosSql = new MotorSQL();
    }
    @Override
    public int add(Sala bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Sala bean) {
        return 0;
    }

    @Override
    public ArrayList<Sala> findAll() throws SQLException {
        String sql = "SELECT * FROM SALA";
        ArrayList<Sala> lstSalas = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);


        try {
            while (rs.next()) {
                Sala sala = new Sala(rs.getInt("id_sala"),
                        rs.getString("nombre"),
                        rs.getInt("capacidad")

                );

                lstSalas.add(sala);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return lstSalas;
    }
}
