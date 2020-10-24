package dao;

import model.Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TecnicoDAO implements Persistencia<Tecnico>{

    @Override
    public int create(Tecnico t) {
        int id = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "INSERT INTO Tecnico (nome, salario, valorHora) VALUES (?,?,?);";

        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, t.getNome());
            pst.setDouble(4, t.getSalario());
            pst.setDouble(5, t.getValorHora());
            pst.execute();

            rs = pst.getGeneratedKeys();
            if (rs.next())
                id = rs.getInt(1);

        } catch (SQLException ex) {
            id = 0;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Tecnico> read() {
        return null;
    }

    @Override
    public boolean update(Tecnico obj) {
        return false;
    }

    @Override
    public boolean delete(Tecnico obj) {
        return false;
    }

    @Override
    public Tecnico findByCodigo(int id) {
        return null;
    }
}
