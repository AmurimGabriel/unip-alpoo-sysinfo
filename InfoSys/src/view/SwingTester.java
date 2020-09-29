package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SwingTester {
    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(JFrame frame){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border raisedbevel  = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border empty = BorderFactory.createEmptyBorder();

        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Black border"));
        panel1.setBorder(blackline);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Raised border"));
        panel2.setBorder(raisedetched);

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Lowered border"));
        panel3.setBorder(loweredetched);

        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Raised Bevel border"));
        panel4.setBorder(raisedbevel);

        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("Lowered Bevel border"));
        panel5.setBorder(loweredbevel);

        JPanel panel6 = new JPanel();
        panel6.add(new JLabel("Empty border"));
        panel6.setBorder(empty);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}

