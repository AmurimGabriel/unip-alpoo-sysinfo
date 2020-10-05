package controller;

import util.Configura;
import view.TelaCadastro;

public class Principal {
    public static void main(String[] args) {
        Configura.LookAndFeel("Windows Classic");
        new TelaCadastro();
    }
}
