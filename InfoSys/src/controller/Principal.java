package controller;

import dao.ConnectionFactory;
import util.Configura;
import view.TelaCadastro;

public class Principal {
    public static void main(String[] args) {
        Configura.LookAndFeel("Windows Classic");
        ConnectionFactory.getConnection();
        new TelaCadastro();
    }
}
