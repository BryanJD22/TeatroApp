package model;

import beans.Valoracion;

import java.sql.SQLException;
import java.util.ArrayList;

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
}
