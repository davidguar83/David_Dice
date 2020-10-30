/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class VentanOrde extends JFrame implements ActionListener {

    JButton botype;
    Container contenidopanel = null;
    ArrayList<Integer> lista = new ArrayList<>();
    int rondas = 5;
    boolean z = false;
    int mio[];
    public VentanOrde() {

        setTitle("semaforo");
        setBounds(300, 300, 500, 500);
        setVisible(true);
        contenidopanel = getContentPane();
        botype = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/David_Dice.png"));
        contenidopanel.setLayout(new GridLayout(2, 2));
        contenidopanel.add(botype);
        botype.setBorderPainted(false);
        botype.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botype) {

            iniciarJuego(e);

        }

    }

    public void iniciarJuego(ActionEvent e) {

        Color color;

        Random ale = new Random();
        for (int i = 0; i < rondas; i++) {

            lista.add(ale.nextInt(4) + 1);

        }

        int[] mio = new int[lista.size()];

        int ind = 0;
        for (Integer value : lista) {

            mio[ind++] = value;

        }

        for (int i = 0; i < mio.length; i++) {

            if (mio[i] == 1) {
                String z = JOptionPane.showInputDialog("siguiente color");
                color = Color.blue;
                System.out.println("azul");

            } else if (mio[i] == 2) {
                String z = JOptionPane.showInputDialog("siguiente color");
                color = Color.RED;
                System.out.println("rojo");

            } else if (mio[i] == 3) {
                String z = JOptionPane.showInputDialog("siguiente color");
                color = Color.GREEN;
                System.out.println("verde");

            } else {
                String z = JOptionPane.showInputDialog("siguiente color");
                color = Color.YELLOW;
                System.out.println("amarillo");

            }

            contenidopanel.setBackground(color);

        }
       
        
        try {
            //try {
            DataOutputStream escribir = new DataOutputStream(new FileOutputStream("C:/Users/david/Desktop/prueba clase file/numeroscolores.txt"));
           
            
            
             for (int j=0;j<mio.length;j++){
                 
                 escribir.write(j);
                 
             }
            escribir.close();
            
        } catch (IOException eee) {
            System.out.println("aaaa");
        }
            
          
         
            
            
      //  } //catch (IOException ex) {
            //System.out.println("error");
       // }
        
        JOptionPane.showInternalInputDialog(botype, "turno jugador\n No cierres la ventana desplazala");

    }

    public void listaventanaorde() {

       
        
        
        

    }

}
