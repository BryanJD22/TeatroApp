package model;

import beans.Obra;
import beans.Valoracion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValorarDAO implements DAO<Valoracion,Integer> {
    MotorSQL motosSql;

    public ValorarDAO() {
        this.motosSql = new MotorSQL();
    }

    @Override
    public int add(Valoracion bean) {
        int resp = 0;
        motosSql.conectar();
        String sql = "INSERT INTO valoracion (valoracion, id_obra, id_usuario) VALUES ("+bean.getValoracion()+","
                + bean.getIdObra()+","+ bean.getIdUsuario()+")";
        System.out.println(sql);

        resp = motosSql.modificar(sql);
        System.out.println(resp);
        return resp;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Valoracion bean) {
        return 0;
    }

    @Override
    public ArrayList<Valoracion> findAll() throws SQLException {



        return null;
    }

    public ArrayList<Valoracion> valoracionObra(Valoracion valoracion) throws SQLException {

        String sql = "SELECT AVG(valoracion) AS valoracion FROM valoracion WHERE id_obra = " + valoracion.getIdObra();
        System.out.println(sql);
        ArrayList<Valoracion> valoracions = new ArrayList<>();
        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);

        try {
            while (rs.next()) {
                Valoracion valoracion1 = new Valoracion(rs.getDouble("valoracion")

                );

                valoracions.add(valoracion1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ObraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return valoracions;
    }




}
