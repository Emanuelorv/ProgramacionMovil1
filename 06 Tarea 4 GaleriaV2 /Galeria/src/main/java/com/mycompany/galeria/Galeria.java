
package com.mycompany.galeria;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author emxv
 */

public class Galeria extends JFrame { // Eliminamos 'implements ActionListener'

    JButton btnAdelante, btnAtras;
    JPanel panelbtn;
    ArrayList<ImageIcon> images;
    int ImgActual;
    JLabel etimage;

    public Galeria() {
        setTitle("Mi Galeria");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        images = new ArrayList<>();
        images.add(new ImageIcon(getClass().getResource("/images/image1.jpg")));
        images.add(new ImageIcon(getClass().getResource("/images/image2.jpg")));
        images.add(new ImageIcon(getClass().getResource("/images/image3.jpg")));

        // Inicializar ImgActual a 0 (aunque es por defecto, se hace para claridad)
        ImgActual = 0;

        etimage = new JLabel();
        showImage(ImgActual); // Muestra la primera imagen al iniciar

        btnAdelante = new JButton("Adelante");
        btnAtras = new JButton("Atras");
        panelbtn = new JPanel();

        // Corrección de Listener para btnAtras usando lambda
        btnAtras.addActionListener(e -> showImage(ImgActual - 1));

        // Corrección de Listener para btnAdelante usando clase anónima
        btnAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(ImgActual + 1);
            }
        });

        panelbtn.add(btnAtras);
        panelbtn.add(btnAdelante);
        add(etimage);
        add(panelbtn);

        // Se recomienda llamar a pack() y no setVisible(true) en el constructor.
        pack();
        // setVisible(true) debe ir en el main para una buena práctica, 
        // pero se dejó donde estaba en tu código original.
        setVisible(true);
    }

    public static void main(String[] args) {
        // La llamada a new Galeria() es suficiente.
        new Galeria();
    }

    // **CORRECCIÓN DE LA LÓGICA DE LÍMITES (CARRUSEL)**
    public void showImage(int newIndex) {
        int totalImages = images.size();

        // 1. Manejo del límite inferior (botón 'Atras'): 
        // Si el nuevo índice es menor que 0, salta al último índice (totalImages - 1).
        if (newIndex < 0) {
            newIndex = totalImages - 1;
        }

        // 2. Manejo del límite superior (botón 'Adelante'): 
        // Si el nuevo índice es igual o mayor que el tamaño, salta al primer índice (0).
        if (newIndex >= totalImages) {
            newIndex = 0;
        }

        // 3. Aplicar los cambios
        if (totalImages > 0) { // Solo actualiza si hay imágenes
            this.ImgActual = newIndex;
            etimage.setIcon(images.get(this.ImgActual));
        }
    }
}
