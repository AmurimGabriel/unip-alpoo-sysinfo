package dao;

import java.sql.*;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:/home/souza/Workspace/IntelliJ/unip-alpoo-sysinfo/InfoSys/database/SysInfoDB.db";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL);
            System.out.println("Banco de Dados conectado!");
            return con;
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão com o bando de dados. \n" + e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados. \n" + e);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement pst) {
        try{
            if (pst != null)
                pst.close();
            closeConnection(con);
        } catch (SQLException throwables) {
            throw new RuntimeException("Erro ao fechar o STATEMENT.");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
        try{
            if (rs != null)
                rs.close();
            closeConnection(con, pst);
        } catch (SQLException throwables) {
            throw new RuntimeException("Erro ao fechar o RESULT SET.");
        }
    }
}
