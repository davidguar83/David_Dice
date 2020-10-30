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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
 */public class VentanaJug extends JFrame implements ActionListener {

    JButton bot1, bot2, bot3, bot4,bot5;
    Container contenidopanel = null;
   
    ArrayList<Integer> listajugador = new ArrayList<>();
    int rondas = 5;
    int puntos = 1;
    boolean z = false;
    int rondaspuntos = 0;
    int rondasjugador = 5;
    int num1, num2, num3, num4;

    public VentanaJug() {

       setTitle("semaforo");
        setBounds(300, 300, 500, 500);
        setVisible(true);
        contenidopanel = getContentPane();
        bot1 = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/azul.png"));
        //bot1.setRolloverIcon(new ImageIcon("C:/Users/david/Desktop/prueba clase file/azul.png"));/cambia la imagen
        bot2 = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/rojo.png"));
        // bot2.setRolloverIcon(new ImageIcon("C:/Users/david/Desktop/prueba clase file/rojo.png"));
        bot3 = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/verde.png"));
        // bot3.setRolloverIcon(new ImageIcon("C:/Users/david/Desktop/prueba clase file/verde.png"));
        bot4 = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/amarillo.png"));
        //  bot4.setRolloverIcon(new ImageIcon("C:/Users/david/Desktop/prueba clase file/amarillo.png"));
        bot5 = new JButton(new ImageIcon("C:/Users/david/Desktop/prueba clase file/David_Dice.png"));

        contenidopanel.setLayout(new GridLayout(2, 2));
        contenidopanel.add(bot1);
        contenidopanel.add(bot2);
        contenidopanel.add(bot3);
        contenidopanel.add(bot4);
        contenidopanel.add(bot5);
        bot1.setBorderPainted(false);
        bot2.setBorderPainted(false);
        bot3.setBorderPainted(false);
        bot4.setBorderPainted(false);
        bot5.setBorderPainted(false);
        bot1.addActionListener(this);
        bot2.addActionListener(this);
        bot3.addActionListener(this);
        bot4.addActionListener(this);
        bot5.addActionListener(this);
    }

   @Override
    public void actionPerformed(ActionEvent ex) {

        if (ex.getSource() == bot1) {
            num1 = 1;
            listajugador.add(num1);

            System.out.println(num1);
        }

        if (ex.getSource() == bot2) {
            num2 = 2;
            listajugador.add(num2);
            System.out.println(num2);
        }

        if (ex.getSource() == bot3) {
            num3 = 3;
            listajugador.add(num3);
            System.out.println(num3);
        }

        if (ex.getSource() == bot4) {
            num4 = 4;
            listajugador.add(num4);
            System.out.println(num4);
        }

        if (ex.getSource() == bot5) {

            
          
            iniciarComprobacion(ex);

        }

    }
    
    public void listajugventajuga(){
        
        System.out.println(listajugador);
        
    }
    

    public void iniciarComprobacion(ActionEvent ex) {
        
        try {
            BufferedReader ler = new BufferedReader(new FileReader(new File("C:/Users/david/Desktop/prueba clase file/numeroscolores.txt")));
            
            String datos=ler.readLine();
            
            ler.close();
            
            int daton=Integer.parseInt(datos);
            
            ArrayList<Integer>lista2=new ArrayList<>();
            
           /*  if (lista2.equals(listajugador)){
            
            System.out.println("Hacertaste");
            puntos++;
            rondas++;
            rondasjugador++;
            rondaspuntos++;
            lista2.clear();
            listajugador.clear();
            } else {
            
            System.out.println("Fallaste");
            lista2.clear();
            z = true;

            int puntostotal = ((rondaspuntos * 10) * puntos);
            System.out.println("puntos = " + puntostotal);
            
            }*/
        } catch (IOException ex1) {
            System.out.println("error");
        }

    }
        
        
       

    }


 