

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Escritorio extends JFrame implements ActionListener {
    private JButton boton1, boton2, boton3, boton4; // Agregar o borrar botones aqui
    private CasaPanel casaPanel;
    public Escritorio() {
        casaPanel = new CasaPanel();

        setTitle("Sistema Operativo");
        setSize(800, 600); // Dimensiones del escritorio
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image imagenFondo = new ImageIcon("")//insertar ruta de imagen
                            .getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        panelFondo.setLayout(null); //Panel transparente 


        JPanel panelSuperiorIzquierda = new JPanel(); 
        JPanel panelInferiorIzquierda = new JPanel();
        JPanel panelSuperiorDerecha = new JPanel();
        JPanel panelInferiorDerecha = new JPanel();

        panelSuperiorIzquierda.setOpaque(false);
        panelInferiorIzquierda.setOpaque(false);
        panelSuperiorDerecha.setOpaque(false);
        panelInferiorDerecha.setOpaque(false);

        panelSuperiorIzquierda.setLayout(new FlowLayout()); //Para poder mover los paneles
        panelInferiorIzquierda.setLayout(new FlowLayout());
        panelSuperiorDerecha.setLayout(new FlowLayout());
        panelInferiorDerecha.setLayout(new FlowLayout());

        boton1 = new JButton(new ImageIcon(""));
        boton2 = new JButton(new ImageIcon(""));
        boton3 = new JButton(new ImageIcon(""));
        boton4 = new JButton(new ImageIcon("")); //Insertar rutas de imagen

        panelSuperiorIzquierda.add(boton1); //Asigno el boton al panel 
        panelInferiorIzquierda.add(boton2);
        panelSuperiorDerecha.add(boton3);
        panelInferiorDerecha.add(boton4);

        panelSuperiorIzquierda.setBounds(0, 0, 200, 200); //Aqui doy las coordenadas, dimension del panel
        panelInferiorIzquierda.setBounds(0, 400, 200, 200);// 0 cordenada x, 400 cordenada y, 200, 200 dimensiones panel
        panelSuperiorDerecha.setBounds( 590, 0, 200, 200);
        panelInferiorDerecha.setBounds( 590, 410, 210, 210);

        panelFondo.add(panelSuperiorIzquierda); //Adiciono los paneles al Panel Fondo
        panelFondo.add(panelInferiorIzquierda);
        panelFondo.add(panelSuperiorDerecha);
        panelFondo.add(panelInferiorDerecha);

        setContentPane(panelFondo);
        setVisible(true);

        boton1.addActionListener(this); //Botones interactuan con lo que hace el usuario
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarImagen();
            }
        });
        boton3.addActionListener(this);
        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Buscador buscador = new Buscador(); // Crear una instancia del buscador
            }
        });
        boton4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == boton1) {
            JOptionPane.showMessageDialog(this, casaPanel, "Panel de Control de Casa", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == boton4) {
            Terminaal.main(null);
        }
    }

    private void mostrarImagen() {
        // Mostrar imagen al hacer clic en el botón2 
        ImageIcon imagen = new ImageIcon(""); //Insertar rutas de imagen
        JOptionPane.showMessageDialog(this, imagen, "Imagen", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new Escritorio(); // Lanza el programa
    }
}
