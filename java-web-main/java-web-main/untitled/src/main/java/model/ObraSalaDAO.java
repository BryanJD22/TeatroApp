package model;

import beans.Obra;
import beans.ObraSala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                bean.getIdSala() + ")" ;
        System.out.println(sql);
        resp = motorSQL.modificar(sql);
        motorSQL.desconectar();
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

    public ArrayList<ObraSala> getFechas(int idObra) throws SQLException {
        String sql = "SELECT id_obra_sala, fecha, hora, id_sala" +
                " FROM obra_sala" +
                " WHERE id_obra =" + idObra;
        System.out.println(sql);
        ArrayList<ObraSala> obraSalas = new ArrayList<>();


        motorSQL.conectar();
        ResultSet rs = motorSQL.consultar(sql);

        try {
            while (rs.next()) {
                ObraSala obraSala = new ObraSala(rs.getInt("id_obra_sala"),
                        rs.getInt("id_sala"),
                        rs.getString("fecha"),
                        rs.getString("hora")

                );

                obraSalas.add(obraSala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motorSQL.desconectar();
        return obraSalas;
    }
}
