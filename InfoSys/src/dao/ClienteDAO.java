package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements Persistencia<Cliente> {

    @Override
    public int create(Cliente c) {
        int id = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "INSERT INTO Cliente (nome, cpf, fone, celular, email) VALUES (?,?,?,?,?);";

        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCpf());
            pst.setString(3, c.getFone());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());
            pst.execute();

            rs = pst.getGeneratedKeys();
            if (rs.next())
                id = rs.getInt(1);

        } catch (SQLException throwables) {
            id = 0;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Cliente> read() {
        return null;
    }

    @Override
    public boolean update(Cliente obj) {
        return false;
    }

    @Override
    public boolean delete(Cliente obj) {
        return false;
    }

    @Override
    public Cliente findByCodigo(int id) {
        return null;
    }
}
