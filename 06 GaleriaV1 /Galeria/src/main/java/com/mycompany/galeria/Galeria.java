package com.mycompany.galeria;

/**
 *
 * @author emanuel ortega ventura
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Galeria extends JFrame implements ActionListener{
    JButton btnAdelante, btnAtras;
    JPanel panelbtn;
    ImageIcon images [];
    int ImgActual;
    JLabel etimage;
   
    public Galeria(){
        setTitle("Mi Galeria");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
       
        images = new ImageIcon[]{
            new ImageIcon("images/image1.jpg"),
            new ImageIcon("images/image2.jpg"),
            new ImageIcon("images/image3.jpg")
        };
       
        etimage = new JLabel();
        etimage.setHorizontalAlignment(JLabel.CENTER);
        etimage.setIcon(images[ImgActual]);
 
       
        btnAdelante = new JButton("Adelante");        
        btnAtras = new JButton("Atras");
        btnAdelante.addActionListener(this);
        btnAtras.addActionListener(this);
        panelbtn = new JPanel();
        panelbtn.add(btnAtras); panelbtn.add(btnAdelante);
        add(etimage);
        add(panelbtn);
    }
   
    public static void main(String[] args) {
        Galeria g = new Galeria();
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAtras)){
          if(ImgActual==0){
              ImgActual=images.length-1;
          }else{
              ImgActual=ImgActual-1;
          }
        }
        if(e.getSource().equals(btnAdelante)){
           if(ImgActual==images.length-1){
              ImgActual=0;
          }else{
              ImgActual=ImgActual+1;
          }
        }
        etimage.setIcon(images[ImgActual]);
    }
   
}