package dao;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements Persistencia<Produto> {

    @Override
    public int create(Produto p) {
        int id = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "INSERT INTO Produto (descricao, estoque, ativo, custo, venda) VALUES (?,?,?,?,?);";

        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getDescricao());
            pst.setInt(2, p.getEstoque());
            pst.setBoolean(3, p.isAtivo());
            pst.setDouble(4, p.getCusto());
            pst.setDouble(5, p.getVenda());
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
    public List<Produto> read() {
        return null;
    }

    @Override
    public boolean update(Produto obj) {
        return false;
    }

    @Override
    public boolean delete(Produto obj) {
        return false;
    }

    @Override
    public Produto findByCodigo(int id) {
        return null;
    }
}
