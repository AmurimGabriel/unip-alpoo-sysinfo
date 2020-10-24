package view.tabPanelsCadastro;

import model.Cliente;
import util.Mascara;

import javax.swing.*;
import java.awt.*;

public class CadCliente extends JPanel {

    private JLabel lbCliNome, lbCliCPF, lbCliFone, lbCliCelular, lbCliEmail;
    private JTextField tfCliNome, tfCliEmail;
    private JFormattedTextField tfCliCPF, tfCliFone, tfCliCelular;

    public CadCliente() {
        initComponents();
        tfCliNome.requestFocus();
        setMask();
        limparCliente();
    }

    private void initComponents() {
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        lbCliNome = new JLabel("Nome: ");
        lbCliCPF = new JLabel("CPF: ");
        lbCliFone = new JLabel("Telefone: ");
        lbCliCelular = new JLabel("Celular: ");
        lbCliEmail = new JLabel("Email: ");

        tfCliNome = new JTextField(25);
        tfCliCPF = new JFormattedTextField();
        tfCliFone = new JFormattedTextField();
        tfCliCelular = new JFormattedTextField();
        tfCliEmail = new JTextField(25);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        this.setLayout(new GridBagLayout());

        this.add(lbCliNome, grid(c, 0, 0, 1));
        this.add(tfCliNome, grid(c, 1, 0, 3));

        this.add(lbCliCPF, grid(c, 0, 1, 1));
        this.add(tfCliCPF, grid(c, 1, 1, 3));

        this.add(lbCliFone, grid(c, 0, 2, 1));
        this.add(tfCliFone, grid(c, 1, 2, 3));

        this.add(lbCliCelular, grid(c, 0, 3, 1));
        this.add(tfCliCelular, grid(c, 1, 3, 3));

        this.add(lbCliEmail, grid(c, 0, 4, 1));
        this.add(tfCliEmail, grid(c, 1, 4, 3));
    }


    private GridBagConstraints grid(GridBagConstraints c, int x, int y, int width) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.ipady = 5;
        c.insets = new Insets(10, 20, 0, 0);

        return c;
    }

    public void gravarCliente() {
        Cliente cliente = new Cliente(
                tfCliNome.getText(),
                tfCliCPF.getText(),
                tfCliFone.getText(),
                tfCliCelular.getText(),
                tfCliEmail.getText()
        );
        System.out.println(cliente);
    }

    public void limparCliente() {
        tfCliNome.setText("");
        tfCliCPF.setText("");
        tfCliFone.setText("");
        tfCliCelular.setText("");
        tfCliEmail.setText("");
    }

    private void setMask() {
        tfCliCPF.setFormatterFactory(Mascara.getCpfMask());
        tfCliFone.setFormatterFactory(Mascara.getFoneFixoMask());
        tfCliCelular.setFormatterFactory(Mascara.getCelularMask());
    }

}
