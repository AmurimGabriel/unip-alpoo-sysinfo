package view.tabPanels;

import util.Mascara;

import javax.swing.*;
import java.awt.*;

public class CadTecnico extends JPanel {

    private JLabel lbTecNome, lbTecSalario, lbTecValorHora;
    private JTextField tfTecNome;
    private JFormattedTextField tfTecSalario, tfTecValorHora;

    public CadTecnico() {
        initComponents();
        setMask();
    }

    private void initComponents() {
        lbTecNome = new JLabel("Nome: ");
        tfTecNome = new JTextField(25);

        lbTecSalario = new JLabel("Salário");
        tfTecSalario = new JFormattedTextField();
        tfTecSalario.setPreferredSize(new Dimension(100, 18));

        lbTecValorHora = new JLabel("Valor da Hora");
        tfTecValorHora = new JFormattedTextField();
        tfTecValorHora.setPreferredSize(new Dimension(70, 18));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        panel.add(lbTecNome, grid(c, 0, 0, 1));
        panel.add(tfTecNome, grid(c, 1, 0, 3));

        panel.add(lbTecSalario, grid(c, 0, 1, 1));
        panel.add(tfTecSalario, grid(c, 1, 1, 2));

        panel.add(lbTecValorHora, grid(c, 0, 2, 1));
        panel.add(tfTecValorHora, grid(c, 1, 2, 1));

        this.add(panel, BorderLayout.WEST);
    }

    private GridBagConstraints grid(GridBagConstraints c, int x, int y, int width) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.ipady = 5;
        c.insets = new Insets(10, 10, 10, 0);

        return c;
    }

    private void setMask() {
        tfTecSalario.setFormatterFactory(Mascara.getValorMask());
        tfTecValorHora.setFormatterFactory(Mascara.getValorMask());
    }
}