


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList; 

public class Terminaal extends JFrame {
    public JTextArea terminalArea;
    public JScrollPane scrollPane;
    private ArrayList<String> commandHistory;
    private String terminalName;
    private JPanel leftPanel; // Panel izquierdo donde se encuentra el pingüino ASCII

    public Terminaal() {
        // Configuración de la ventana principal
        setTitle("HeroXTerminal");

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Solicitar al usuario que ingrese el nombre de la terminal
        terminalName= JOptionPane.showInputDialog(null, "Ingrese el nombre de la terminal:");

        // Configuración del panel izquierdo (donde se encuentra el pingüino ASCII)
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        // Mostrar el pingüino ASCII en el panel izquierdo
        JTextArea asciiArtArea = new JTextArea(getAsciiArt());
        asciiArtArea.setEditable(false);
        asciiArtArea.setBackground(Color.BLACK);
        asciiArtArea.setForeground(Color.CYAN);
        asciiArtArea.setFont(new Font("Monospaced", Font.PLAIN, 8));
        leftPanel.add(asciiArtArea, BorderLayout.CENTER);

        // Mostrar saludo en la parte inferior del panel izquierdo
        JTextArea greetingArea = new JTextArea("¡Bienvenido a la terminal HeroXTerminal!\n\n¡SHHH no se lo digas a nadie...\n Aquí tienes una pequeña chuleta de nuestros comandos!\n Comandos:\n   hola caracola\n   pintar\n   tematica\n   personalizar\n   fiesta");
        greetingArea.setEditable(false);
        greetingArea.setBackground(Color.BLACK);
        greetingArea.setForeground(Color.CYAN);
        greetingArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        leftPanel.add(greetingArea, BorderLayout.SOUTH);

        // Configuración del panel derecho (donde se encuentra la terminal)
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Configuración del área de texto (terminal)
        terminalArea = new JTextArea();
        terminalArea.setEditable(true);
        terminalArea.setBackground(Color.BLACK);
        terminalArea.setForeground(Color.CYAN);
        terminalArea.setCaretColor(Color.PINK);
        terminalArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        // Configuración del panel de desplazamiento para el área de texto
        scrollPane = new JScrollPane(terminalArea);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Configuración del divisor para dividir la pantalla en dos partes
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400); // Ubicación de la barra divisoria

        add(splitPane);

        // Mostrar la ruta actual antes de solicitar el comando
        appendToTerminal(getCurrentPath() + "> ");
        
        // Inicializar el historial de comandos
        commandHistory = new ArrayList<>();

        // Configuración del evento de teclado para procesar comandos al presionar Enter
        terminalArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    processCommand();
                    evt.consume();
                }
            }
        });

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método para obtener la ruta actual del directorio de trabajo
    public String getCurrentPath() {
        return terminalName + ":";
    }
    
    // Método para procesar el comando ingresado
    public void processCommand() {
        String command = getCommand();
        commandHistory.add(command);
        switch (command.toLowerCase()) {
            case "hola caracola":
                appendToTerminal("\nhola guap@");
               break;
            case "clear":
                terminalArea.setText(""); // Limpiar el contenido del área de texto
                terminalArea.setCaretPosition(0); // Mover el cursor al principio del texto
                break;
            case "history":
                appendToTerminal("");
                for (int i = 0; i < commandHistory.size(); i++) {
                    appendToTerminal((i + 1) + " " + commandHistory.get(i));
                }
                break;
            case "pintar":
            	appendToTerminal("");
            	startPaintSimulator();
                break;
            case "tematica" :
            	appendToTerminal("");
                String opcion = JOptionPane.showInputDialog("Seleccione la temática:\n1. Hacker \n2. Coquette \n3.Clásico \n4.Spiderman \n5.Iron Man");

                switch (opcion) {
                    case "1":
                        setTerminalAndLeftPanelColors(Color.BLACK, Color.GREEN);
                        break;
                    case "2":
                        setTerminalAndLeftPanelColors(Color.PINK, Color.MAGENTA);
                        break;
                    case "3":
                    	setTerminalAndLeftPanelColors(Color.BLACK, Color.WHITE);
                        break;
                    case "4":
                    	setTerminalAndLeftPanelColors(Color.BLUE, Color.RED);
                    	break;
                    case "5":
                    	setTerminalAndLeftPanelColors(Color.RED, Color.YELLOW);
                    	break;
 
                    default:
                        appendToTerminal("Opción no válida.");
                        break;
                }
                break;
            case "personalizar": 
                setTerminalColors();
                setLeftPanelColors();
                break;
            case "fiesta":
            	appendToTerminal("");
                new Thread(() -> {
                    try {
                        for (int i = 0; i < 10; i++) {
                            terminalArea.setBackground(Color.RED);
                            leftPanel.setBackground(Color.RED); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.GREEN);
                            leftPanel.setBackground(Color.GREEN); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.BLUE);
                            leftPanel.setBackground(Color.BLUE); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.MAGENTA);
                            leftPanel.setBackground(Color.MAGENTA); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.RED);
                            leftPanel.setBackground(Color.RED); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.YELLOW);
                            leftPanel.setBackground(Color.YELLOW); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.CYAN);
                            leftPanel.setBackground(Color.CYAN); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.ORANGE);
                            leftPanel.setBackground(Color.ORANGE); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.BLUE);
                            leftPanel.setBackground(Color.BLUE); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.GREEN);
                            leftPanel.setBackground(Color.GREEN); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.RED);
                            leftPanel.setBackground(Color.RED); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                            terminalArea.setBackground(Color.BLUE);
                            leftPanel.setBackground(Color.BLUE); // Cambiar el fondo del panel izquierdo
                            Thread.sleep(50);
                        }
                        terminalArea.setBackground(Color.BLACK); // Vuelve al color negro al final
                        leftPanel.setBackground(Color.BLACK); // Vuelve al color negro al final
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                break;
            default:
                // Si no coincide con ningún comando predefinido, se asume que es un comando de Bash
            	appendToTerminal("");
            	executeBashCommand(command);
                break;
        }
        appendToTerminal(getCurrentPath() + "> ");  // Mostrar la ruta actual antes de solicitar el próximo comando
        setCommand("");  // Limpiar el área de entrada
    }

    // Método para ejecutar el comando ingresado en bash
    private void executeBashCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            process.waitFor();

            // Leer la salida del comando y mostrarla en el terminal
            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            appendToTerminal(scanner.hasNext() ? scanner.next() : "");
        } catch (Exception e) {
            appendToTerminal("Error al ejecutar el comando: " + e.getMessage());
        }
    }

    // Método para cambiar el color de fondo y de letra de la terminal
    public void setTerminalColors() {
        // Solicitar al usuario que seleccione los colores en español
        String fondo = JOptionPane.showInputDialog("Ingrese el color de fondo para la terminal:");
        String letra = JOptionPane.showInputDialog("Ingrese el color de letra para la terminal:");

        // Mapear los colores ingresados a sus equivalentes en inglés
        String fondoEnIngles = obtenerColorEnIngles(fondo);
        String letraEnIngles = obtenerColorEnIngles(letra);

        // Verificar si los colores ingresados son válidos
        try {
            Color fondoColor = (Color) Color.class.getField(fondoEnIngles.toUpperCase()).get(null);
            Color letraColor = (Color) Color.class.getField(letraEnIngles.toUpperCase()).get(null);

            // Establecer los colores en la terminal
            terminalArea.setBackground(fondoColor);
            terminalArea.setForeground(letraColor);

            appendToTerminal("Colores de la terminal cambiados.");
        } catch (Exception e) {
            appendToTerminal("Error: Color no válido.");
        }
    }

    // Método para cambiar el color de fondo y de letra del panel izquierdo (donde se encuentra el pingüino ASCII)
    public void setLeftPanelColors() {
        // Solicitar al usuario que seleccione los colores en español
        String fondo = JOptionPane.showInputDialog("Ingrese el color de fondo para el panel izquierdo:");
        String letra = JOptionPane.showInputDialog("Ingrese el color de letra para el panel izquierdo:");

        // Mapear los colores ingresados a sus equivalentes en inglés
        String fondoEnIngles = obtenerColorEnIngles(fondo);
        String letraEnIngles = obtenerColorEnIngles(letra);

        // Verificar si los colores ingresados son válidos
        try {
            Color fondoColor = (Color) Color.class.getField(fondoEnIngles.toUpperCase()).get(null);
            Color letraColor = (Color) Color.class.getField(letraEnIngles.toUpperCase()).get(null);

            // Establecer los colores en el panel izquierdo
            leftPanel.setBackground(fondoColor);

            // Cambiar el color del texto dentro del panel izquierdo (pingüino ASCII y saludo)
            for (Component component : leftPanel.getComponents()) {
                if (component instanceof JTextArea) {
                    JTextArea textArea = (JTextArea) component;
                    textArea.setForeground(letraColor);
                }
            }

            appendToTerminal("Colores del panel izquierdo cambiados.");
        } catch (Exception e) {
            appendToTerminal("Error: Color no válido.");
        }
    }

    // Método para mapear los colores ingresados en español a sus equivalentes en inglés
    private String obtenerColorEnIngles(String color) {
        switch (color.toLowerCase()) {
            case "rojo":
                return "RED";
            case "verde":
                return "GREEN";
            case "azul":
                return "BLUE";
            case "amarillo":
                return "YELLOW";
            case "naranja":
                return "ORANGE";
            case "aqua":
                return "CYAN";
            case "morado":
                return "MAGENTA";
            case "rosa":
                return "PINK";
            case "blanco":
                return "WHITE";
            case "negro":
                return "BLACK";
            default:
                return color.toUpperCase(); // Si no se encuentra, se asume que el color está en inglés
        }
    }

    // Método para agregar texto al área de texto (terminal)
    public void appendToTerminal(String text) {
        SwingUtilities.invokeLater(() -> {
            terminalArea.append(text + "\n");
            terminalArea.setCaretPosition(terminalArea.getDocument().getLength());
        });
    }

    // Método para obtener el comando ingresado
    public String getCommand() {
        String text = terminalArea.getText();
        int lastNewLine = text.lastIndexOf("\n");
        if (lastNewLine >= 0) {
            return text.substring(lastNewLine + 1);
        } else {
            return text;
        }
    }

    // Método para establecer el texto en el área de entrada del terminal
    public void setCommand(String command) {
        SwingUtilities.invokeLater(() -> terminalArea.setText(terminalArea.getText() + command));
    }

    // Clase PaintSimulator integrada
    static class PaintSimulator extends JPanel {
        private int lastX, lastY;

        public PaintSimulator() {
            setPreferredSize(new Dimension(600, 400));
            setBackground(Color.PINK);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();
                    int x = e.getX();
                    int y = e.getY();
                    g.drawLine(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    // Método para iniciar el simulador de pintura
    private void startPaintSimulator() {
        JFrame paintFrame = new JFrame("Paint Simulator");
        paintFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        paintFrame.getContentPane().add(new PaintSimulator());
        paintFrame.pack();
        paintFrame.setLocationRelativeTo(null); // Centrar la ventana
        paintFrame.setVisible(true);
    }

    // Método para cambiar el color de fondo y de letra de la terminal y del panel izquierdo
    private void setTerminalAndLeftPanelColors(Color fondoColor, Color letraColor) {
        terminalArea.setBackground(fondoColor);
        terminalArea.setForeground(letraColor);
        leftPanel.setBackground(fondoColor);
        for (Component component : leftPanel.getComponents()) {
            if (component instanceof JTextArea) {
                JTextArea textArea = (JTextArea) component;
                textArea.setForeground(letraColor);
            }
        }
    }

    // Método para obtener el arte ASCII del pingüino
    private String getAsciiArt() {
        return  
            "                 .88888888:.\n" +
            "                88888888.88888.\n" +
            "              .8888888888888888.\n" +
            "              888888888888888888\n" +
            "              88' `88'  `88888\n" +
            "              88 88 88 88  88888\n" +
            "              88_88_::88:88888\n" +
            "              88:::,::,:::::8888\n" +
            "              88`:::::::::'`8888\n" +
            "             .88  `::::'    8:88.\n" +
            "            8888            `8:888.\n" +
            "          .8888'             `888888.\n" +
            "         .8888:..  .::.  ...:'8888888:.\n" +
            "        .8888.'     :'     `'::`88:88888\n" +
            "       .8888        '         `.888:8888.\n" +
            "      888:8         .           888:88888\n" +
            "    .888:88        .:           888:88888:\n" +
            "    8888888.       ::           88:888888\n" +
            "    `.::.888.      ::          .88888888\n" +
            "   .::::::.888.    ::         :::`8888'.:.\n" +
            "  ::::::::::.888   '         .::::::::::::\n" +
            "  ::::::::::::.8    '      .:8::::::::::::.\n" +
            " .::::::::::::::.        .:888:::::::::::::\n" +
            " :::::::::::::::88:.__..:88888:::::::::::'\n" +
            "  `'.:::::::::::88888888888.88:::::::::'\n" +
            "...     '::::' -- '' -'-' `':::::'\n";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Terminaal());
    }
}
