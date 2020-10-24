package view;

import view.tabPanelsCadastro.CadCliente;
import view.tabPanelsCadastro.CadProduto;
import view.tabPanelsCadastro.CadTecnico;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class TelaCadastro extends JFrame {

    private JPanel pnTitulo, pnButtons, pnServico, pnTecnico;
    private JTabbedPane pnTela;
    private CadCliente pnCliente;
    private CadProduto pnProduto;

    private JLabel lbTitulo, lbLogo;
    private JButton btGravar, btLimpar;

    public TelaCadastro() {
        initComponents();
    }

    public static void main(String[] args) {
        new TelaCadastro();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void initComponents() {
        /* INICIO PAINEL TITULO */
        /* Criando painel de cima resposavel pelo titulo da janela */

        pnTitulo = new JPanel(new BorderLayout());
        pnTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        /* Instanciando, definindo fonte e centralizando o texto */
        lbTitulo = new JLabel("Cadastro");
        lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setVerticalAlignment(SwingConstants.CENTER);

        /* Buscando imagem e atribuindo um label vazio que ficará a esquerda */
        ImageIcon imgLogo = new ImageIcon("src/resources/InfoSysLogo-Pequeno.jpeg");
        lbLogo = new JLabel(imgLogo);
        lbLogo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        pnTitulo.add(lbLogo, BorderLayout.WEST);
        pnTitulo.add(lbTitulo, BorderLayout.CENTER);
        /* FIM PAINEL TITULO */

        /* INICIO PAINEL DE ABAS */
        pnTela = new JTabbedPane();
        pnTela.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        pnCliente = new CadCliente();
        pnTela.addTab("Cliente", pnCliente);

        pnProduto = new CadProduto();
        pnTela.addTab("Produto", pnProduto);

        pnServico = new JPanel();
        pnTela.addTab("Serviços", pnServico);

        pnTecnico = new CadTecnico();
        pnTela.addTab("Técnicos", pnTecnico);
        /* FIM PAINEL DE ABAS */

        /* INICIO PAINEL BOTOES */
        pnButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        btGravar = new JButton("Gravar");
        btLimpar = new JButton("Limpar");

        pnButtons.add(btGravar);
        pnButtons.add(btLimpar);
        acaoBotoes();
        /*FIM PAINEL BOTOES*/

        this.add(pnButtons, BorderLayout.SOUTH);
        this.add(pnTela, BorderLayout.CENTER);
        this.add(pnTitulo, BorderLayout.NORTH);

        this.setSize(500, 425);
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void acaoBotoes() {
        btLimpar.addActionListener(e -> {
            if (pnTela.getSelectedComponent() == pnCliente)
                pnCliente.limparCliente();
            else if (pnTela.getSelectedComponent() == pnProduto)
                pnProduto.limparProduto();
        });

        btGravar.addActionListener(e -> {
            if (pnTela.getSelectedComponent() == pnCliente)
                pnCliente.gravarCliente();
            else if (pnTela.getSelectedComponent() == pnProduto) {
                pnProduto.gravarProduto();
            }
        });
    }
}
