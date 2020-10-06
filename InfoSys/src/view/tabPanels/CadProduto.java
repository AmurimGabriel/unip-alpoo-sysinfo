package view.tabPanels;

import model.Produto;
import util.Mascara;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CadProduto extends JPanel {

    private JLabel lbProDescricao, lbProEstoque, lbProAtivo, lbProCusto, lbProVenda;
    private JTextField tfProDescricao;
    private JFormattedTextField tfProCusto = null, tfProVenda = null;
    private JSpinner spProEstoque;
    private JCheckBox cbProAtivo;

    public CadProduto() {
        initComponents();
        setMask();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbProDescricao = new JLabel("Descricao: ");
        tfProDescricao = new JTextField(25);
        tfProDescricao.setPreferredSize(new Dimension(350, 25));

        JPanel pnProDescricao = new JPanel();
        pnProDescricao.add(lbProDescricao);
        pnProDescricao.add(tfProDescricao);

        lbProEstoque = new JLabel("Estoque: ");
        spProEstoque = new JSpinner();
        spProEstoque.setPreferredSize(new Dimension(100, 25));
        spProEstoque.addChangeListener(e -> {
            int v = (int) spProEstoque.getValue();
            if (v < 0) spProEstoque.setValue(0);
        });

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
        tfProCusto = new JFormattedTextField();
        tfProCusto.setPreferredSize(new Dimension(120, 25));

        lbProVenda = new JLabel("Venda: ");
        lbProVenda.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 0));
        tfProVenda = new JFormattedTextField();
        tfProVenda.setPreferredSize(new Dimension(120, 25));

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

    public void gravarProduto() {
        Produto produto = new Produto(
                tfProDescricao.getText(),
                (int) spProEstoque.getValue(),
                cbProAtivo.isSelected(),
                Double.parseDouble(tfProVenda.getText()),
                Double.parseDouble(tfProCusto.getText())
        );
        System.out.println(produto);
    }

    public void limparProduto() {
        tfProDescricao.setText("");
        spProEstoque.setValue(0);
        cbProAtivo.setSelected(false);
        tfProCusto.setValue(0);
        tfProVenda.setValue(0);
    }

    public void setMask() {
        tfProCusto.setFormatterFactory(Mascara.getValorMask());
        tfProVenda.setFormatterFactory(Mascara.getValorMask());
    }
}
