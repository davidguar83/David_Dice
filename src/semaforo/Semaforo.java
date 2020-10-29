/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.jfr.Event;

/**
 *
 * @author david
 */
public class Semaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Ventana ven = new Ventana();

        ven.setVisible(true);

        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class Ventana extends JFrame implements ActionListener {

    JButton bot1, bot2, bot3, bot4, bot5;
    Container contenidopanel = null;
    ArrayList<Integer> lista = new ArrayList<>();
    ArrayList<Integer> listajugador = new ArrayList<>();
    int rondaspuntos = 0;
    int puntos = 1;
    boolean z = false;
    int rondas = 5;
    int rondasjugador = 5;
    int num1, num2, num3, num4;

    public Ventana() {

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

            iniciarJuego(ex);

        }

    }

    public void iniciarJuego(ActionEvent e) {

        Color color;

        do {
           // if (e.getSource() == bot5) {

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

           // }

            System.out.println("turno jugador");
            System.out.println(listajugador);
            
            actionPerformed(e);
            turnoJugador(e);
            // pulsarBotones(e);
            // start();
            comprobarResultados();
        } while (z == false);

    }

    public void comprobarResultados() {

        if (lista.equals(listajugador)) {

            System.out.println("Hacertaste");
            puntos++;
            rondas++;
            rondasjugador++;
            rondaspuntos++;
            lista.clear();
            listajugador.clear();
        } else {

            System.out.println("Fallaste");
            lista.clear();
            z = true;

            int puntostotal = ((rondaspuntos * 10) * puntos);
            System.out.println("puntos = " + puntostotal);

        }

    }

    public void start() {

        for (int i = 0; i < rondasjugador; i++) {

            int a = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero"));;

            listajugador.add(a);

        }
        System.out.println(listajugador);

    }

    public void turnoJugador(ActionEvent ee) {

        if (ee.getSource() == bot1) {
            num1 = 1;
            listajugador.add(num1);

            System.out.println(num1);
        }

        if (ee.getSource() == bot2) {
            num2 = 2;
            listajugador.add(num2);
            System.out.println(num2);
        }

        if (ee.getSource() == bot3) {
            num3 = 3;
            listajugador.add(num3);
            System.out.println(num3);
        }

        if (ee.getSource() == bot4) {
            num4 = 4;
            listajugador.add(num4);
            System.out.println(num4);
        }

    }

}
