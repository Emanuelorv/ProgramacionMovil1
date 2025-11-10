package bolita;

/**
 * @author emanuel
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends JFrame implements ActionListener {

    JPanel pt, pd, pb;
    int posX = 0, posY = 0; // Posición inicial ajustada para que se vea
    JButton btnAdelante, btnAtras, btnArriba, btnAbajo;

    public Bolita() {
        setTitle("Bolita 01");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Panel de texto y dibujo
        pt = new PanelTexto();
        pd = new PanelDibujo();

        // Panel de botones (4 botones ahora)
        pb = new JPanel();
        pb.setLayout(new GridLayout(1, 4)); // antes era (1,2)

        // Crear botones
        btnAtras = new JButton("<<");
        btnAdelante = new JButton(">>");
        btnArriba = new JButton("↑");
        btnAbajo = new JButton("↓");

        // Asociar eventos
        btnAtras.addActionListener(this);
        btnAdelante.addActionListener(this);
        btnArriba.addActionListener(this);
        btnAbajo.addActionListener(this);

        // Añadir botones al panel inferior
        pb.add(btnAtras);
        pb.add(btnAdelante);
        pb.add(btnArriba);
        pb.add(btnAbajo);

        // Añadir paneles a la ventana
        add(pt);
        add(pd);
        add(pb);

        setLocationRelativeTo(null); // Centra la ventana en pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int width = pd.getWidth();  // límite horizontal
        int height = pd.getHeight(); // límite vertical

        // Movimiento horizontal →
        if (e.getSource().equals(btnAdelante)) {
            posX += 10;
            if (posX > width) posX = 0;
        }

        // Movimiento horizontal ←
        if (e.getSource().equals(btnAtras)) {
            posX -= 10;
            if (posX < 0) posX = width;
        }

        // Movimiento vertical ↑
        if (e.getSource().equals(btnArriba)) {
            posY -= 10;
            if (posY < 0) posY = height;
        }

        // Movimiento vertical ↓
        if (e.getSource().equals(btnAbajo)) {
            posY += 10;
            if (posY > height) posY = 0;
        }

        // Redibuja la bolita
        pd.repaint();
    }

    // Panel superior: título
    private class PanelTexto extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            Font font = new Font("Arial", Font.BOLD, 20); // corregido
            g.setFont(font);
            g.drawString("Juego Bolita", 10, 25);
        }
    }

    // Panel central: dibujo
    private class PanelDibujo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.ORANGE);
            g.fillOval(posX, posY, 20, 20);
        }
    }

    public static void main(String[] args) {
        Bolita b = new Bolita();
        b.setVisible(true);
    }
}