
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Buscador extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton searchButton;

    private HashMap<String, String> imagenes;

    public Buscador() {
        setTitle("Buscador");
        setSize(400, 80); //dimensiones buscador
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        imagenes = new HashMap<>();
     // Modificar aqui abajo
        imagenes.put("lampara",""); 
        imagenes.put("llaves", "");
        imagenes.put("perfume", ""); //palabra clave y ruta de imagen 
//Fin de la modificación 
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField = new JTextField(20);
        searchButton = new JButton("Buscar");
        searchButton.addActionListener(this);

        panel.add(textField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String query = textField.getText().toLowerCase();
        if (imagenes.containsKey(query)) {
        	
        	ImageIcon icon = new ImageIcon(imagenes.get(query));
            JOptionPane.showMessageDialog(this, new JLabel(icon), "Resultado", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados para: " + query, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Buscador();
    }
}
