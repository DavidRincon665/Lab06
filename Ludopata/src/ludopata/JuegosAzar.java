/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ludopata;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase principal
public class JuegosAzar extends JFrame {

    public JuegosAzar() {
        setTitle("Simulación de Juegos de Azar");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de botones para seleccionar juegos
        JPanel panelMenu = new JPanel();
        JButton btnDados = new JButton("Juego de Dados");
        JButton btnTragamonedas = new JButton("Juego de Tragamonedas");

        panelMenu.add(btnDados);
        panelMenu.add(btnTragamonedas);

        add(panelMenu, BorderLayout.CENTER);

        // Acción para iniciar el juego de dados
        btnDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoDados juegoDados = new JuegoDados();
                Thread hiloDados = new Thread(juegoDados);
                hiloDados.start();
            }
        });

        // Acción para iniciar el juego de tragamonedas
        btnTragamonedas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoTragamonedas juegoTragamonedas = new JuegoTragamonedas();
                Thread hiloTragamonedas = new Thread(juegoTragamonedas);
                hiloTragamonedas.start();
            }
        });
    }

    // Clase para el Juego de Dados
    class JuegoDados implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            int dado1 = random.nextInt(6) + 1; // Número entre 1 y 6
            int dado2 = random.nextInt(6) + 1;
            int suma = dado1 + dado2;

            // Mostrar resultado en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, "Resultado de los dados:\nDado 1: " + dado1 + "\nDado 2: " + dado2 + "\nSuma: " + suma);
        }
    }

    // Clase para el Juego de Tragamonedas
    class JuegoTragamonedas implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            String[] simbolos = {"🍒", "🔔", "⭐", "💎", "🍀", "7"};

            // Simular los tres rodillos de la tragamonedas
            String rodillo1 = simbolos[random.nextInt(simbolos.length)];
            String rodillo2 = simbolos[random.nextInt(simbolos.length)];
            String rodillo3 = simbolos[random.nextInt(simbolos.length)];

            // Mostrar resultado en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, "Resultado de la Tragamonedas:\n" +
                    rodillo1 + " | " + rodillo2 + " | " + rodillo3);

            // Verificar si se ganó o no
            if (rodillo1.equals(rodillo2) && rodillo2.equals(rodillo3)) {
                JOptionPane.showMessageDialog(null, "¡Felicidades! ¡Has ganado!");
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, ¡intenta de nuevo!");
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegosAzar().setVisible(true);
            }
        });
    }
}
