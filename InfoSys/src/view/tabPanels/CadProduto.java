package view.tabPanels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CadProduto extends JPanel {

    private JLabel lbProDescricao, lbProEstoque, lbProAtivo, lbProCusto, lbProVenda;
    private JTextField tfProDescricao, tfProCusto, tfProVenda;
    private JSpinner spProEstoque;
    private JCheckBox cbProAtivo;

    public CadProduto() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbProDescricao = new JLabel("Descricao: ");
        tfProDescricao = new JTextField(25);
        tfProDescricao.setPreferredSize(new Dimension(350,25));

        JPanel pnProDescricao = new JPanel();
        pnProDescricao.add(lbProDescricao);
        pnProDescricao.add(tfProDescricao);

        lbProEstoque = new JLabel("Estoque: ");
        spProEstoque = new JSpinner();
        spProEstoque.setPreferredSize(new Dimension(100,25));

        lbProAtivo = new JLabel("Ativo");
        cbProAtivo = new JCheckBox();
        cbProAtivo.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0));

        JPanel pnProEstoqueAtivo = new JPanel();
        pnProEstoqueAtivo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        pnProEstoqueAtivo.add(lbProEstoque);
        pnProEstoqueAtivo.add(spProEstoque);
        pnProEstoqueAtivo.add(cbProAtivo);
        pnProEstoqueAtivo.add(lbProAtivo);

        lbProCusto = new JLabel("Custo: ");
        tfProCusto = new JTextField(10);
        tfProCusto.setPreferredSize(new Dimension(120,25));

        lbProVenda = new JLabel("Venda: ");
        lbProVenda.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 0));
        tfProVenda = new JTextField(10);
        tfProVenda.setPreferredSize(new Dimension(120,25));

        JPanel pnProPreco = new JPanel();
        pnProPreco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Preço",
                TitledBorder.LEFT, TitledBorder.TOP));

        pnProPreco.add(lbProCusto);
        pnProPreco.add(tfProCusto);
        pnProPreco.add(lbProVenda);
        pnProPreco.add(tfProVenda);

        this.add(pnProDescricao, BorderLayout.NORTH);
        this.add(pnProEstoqueAtivo, BorderLayout.CENTER);
        this.add(pnProPreco, BorderLayout.SOUTH);
    }

}
