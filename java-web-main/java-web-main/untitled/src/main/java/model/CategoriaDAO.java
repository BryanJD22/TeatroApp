package model;

import beans.Categoria;
import beans.Obra;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO implements DAO<Categoria,Integer> {
    MotorSQL motosSql;

    public CategoriaDAO() {
        this.motosSql = new MotorSQL();
    }
    @Override
    public int add(Categoria bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Categoria bean) {
        return 0;
    }

    @Override
    public ArrayList<Categoria> findAll() throws SQLException {
        String sql = "SELECT * FROM CATEGORIA";
        ArrayList<Categoria> lstCategorias = new ArrayList<>();

        motosSql.conectar();
        ResultSet rs = motosSql.consultar(sql);


        try {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                                                rs.getString("nombre_categoria")

                );

                lstCategorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        motosSql.desconectar();
        return lstCategorias;
    }
}
