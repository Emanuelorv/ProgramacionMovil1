import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Manejador2 extends JFrame implements ActionListener {

    Button b1, b2;
    JButton b3, b4;
    JPanel pc, pc2;
    JLabel etiquetaNombre, etiquetapanel2;
    JTextField nombreDado;
    JButton btnEnviarDatos;

    public Manejador2() {
        setTitle("Programa 01");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2));

        etiquetaNombre = new JLabel("Nombre: ");
        nombreDado = new JTextField(20);
        btnEnviarDatos = new JButton("Enviar");
        btnEnviarDatos.addActionListener(this);

        pc = new JPanel();
        pc.setBackground(Color.WHITE);

        pc2 = new JPanel();
        etiquetapanel2 = new JLabel();
        pc2.add(etiquetapanel2);

        pc.add(etiquetaNombre);
        pc.add(nombreDado);
        pc.add(btnEnviarDatos);

        b1 = new Button("azul");
        b2 = new Button("naranja");
        b3 = new JButton("verde");
        b4 = new JButton("rojo");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(pc);
        add(pc2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1.equals(e.getSource())) {
            System.out.println("azul");
            pc.setBackground(Color.BLUE);
        }
        if (e.getSource().equals(b2)) {
            System.out.println("naranja");
            pc.setBackground(Color.ORANGE);
        }
        if (e.getSource().equals(b3)) {
            System.out.println("verde");
            pc.setBackground(Color.GREEN);
        }
        if (e.getSource().equals(b4)) {
            System.out.println("rojo");
            //Color rojo = new Color(5);
            //pc.setBackground(rojo);
            pc.setBackground(Color.red);
        }

        if (e.getSource().equals(btnEnviarDatos)) {
            String nombre = nombreDado.getText() + "";
            JOptionPane.showMessageDialog(null, "hola " + nombre);
            etiquetapanel2.setText("Hola " + nombre);
        }
    }

}