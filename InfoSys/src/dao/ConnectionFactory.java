package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
