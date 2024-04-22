

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CasaPanel extends JPanel {
    private JLabel temperaturaLabel;
    private JSlider temperaturaSlider;
    private JLabel lucesLabel;
    private JToggleButton[] lucesButtons;
    private JButton guardarButton;

    private int temperatura;
    private boolean[] luces;

    public CasaPanel() {
        temperatura = 20; 
        luces = new boolean[6]; 

        setLayout(new GridLayout(0, 1));
        setBackground(Color.GRAY); 

        temperaturaLabel = new JLabel("Temperatura: " + temperatura + "°C");
        temperaturaSlider = new JSlider(JSlider.HORIZONTAL, 0, 30, temperatura);
        temperaturaSlider.setMajorTickSpacing(5);
        temperaturaSlider.setMinorTickSpacing(1);
        temperaturaSlider.setPaintTicks(true);
        temperaturaSlider.setPaintLabels(true);
        temperaturaSlider.addChangeListener(new TemperaturaChangeListener());

        lucesLabel = new JLabel("Luces:"); 
        lucesButtons = new JToggleButton[6];
        for (int i = 0; i < 6; i++) {
            luces[i] = false; 
            lucesButtons[i] = new JToggleButton("Luz " + (i + 1));
            lucesButtons[i].setBackground(Color.BLACK);
            lucesButtons[i].setForeground(Color.WHITE); 
            lucesButtons[i].addActionListener(new LuzActionListener(i));
        }

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	JOptionPane.showMessageDialog(CasaPanel.this, "Estado de la casa guardado");
            }
        });

        add(temperaturaLabel);
        add(temperaturaSlider);
        add(lucesLabel);
        for (int i = 0; i < 6; i++) {
            add(lucesButtons[i]);
        }
        add(guardarButton);
    }

    private class TemperaturaChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            temperatura = temperaturaSlider.getValue();
            temperaturaLabel.setText("Temperatura: " + temperatura + "°C");
        }
    }

    private class LuzActionListener implements ActionListener {
        private int index;

        public LuzActionListener(int index) {
            this.index = index;
        }

        public void actionPerformed(ActionEvent e) {
            luces[index] = lucesButtons[index].isSelected();
            if (luces[index]) {
                lucesButtons[index].setBackground(Color.WHITE);
            } else {
                lucesButtons[index].setBackground(Color.BLACK);
            }
        }
    }

    public int getTemperatura() {
        return temperatura;
    }

    public boolean[] getLuces() {
        return luces;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel de Control de Casa");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        CasaPanel casaPanel = new CasaPanel();
        frame.add(casaPanel);

        JButton boton1 = new JButton("Mostrar Panel de Control");
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, casaPanel, "Panel de Control de Casa", JOptionPane.PLAIN_MESSAGE);
            }
        });
        frame.add(boton1, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
