import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioFrame extends JFrame {

    private static JPanel contentPane = new JPanel();
    private static ButtonGroup groupColoreTesto;
    private static ButtonGroup groupColoreSfondoTesto;
    private static ButtonGroup groupColoreSfondoFinestra;

    private static JTextField txtscritta;
    private static JLabel lblcolore;

    public static void main(String[] args) {
        new RadioFrame();
    }

    public RadioFrame() {
        
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        contentPane.setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // Creazione JTextField
        txtscritta = new JTextField("ciao mondo");
        txtscritta.setBounds(83, 250, 150, 26);
        contentPane.add(txtscritta);
        
        // Creazione JLabel
        lblcolore = new JLabel();
        lblcolore.setBounds(83, 280, 200, 26);
        contentPane.add(lblcolore);
        
        // Creazione JRadioButtons per il colore del testo
        groupColoreTesto = new ButtonGroup();
        JRadioButton jButt1 = createRadioButton("Rosso", 83, 86, groupColoreTesto, Color.red);
        JRadioButton jButt2 = createRadioButton("Arancione", 83, 116, groupColoreTesto, Color.orange);
        JRadioButton jButt3 = createRadioButton("Giallo", 83, 146, groupColoreTesto, Color.yellow);
        JRadioButton jButt4 = createRadioButton("Verde", 83, 176, groupColoreTesto, Color.green);
        JRadioButton jButt5 = createRadioButton("Blu", 83, 206, groupColoreTesto, Color.blue);

        // Creazione JRadioButtons per il colore di sfondo della casella di testo
        groupColoreSfondoTesto = new ButtonGroup();
        JRadioButton jButt6 = createRadioButton("Rosso", 200, 86, groupColoreSfondoTesto, Color.red);
        JRadioButton jButt7 = createRadioButton("Arancione", 200, 116, groupColoreSfondoTesto, Color.orange);
        JRadioButton jButt8 = createRadioButton("Giallo", 200, 146, groupColoreSfondoTesto, Color.yellow);
        JRadioButton jButt9 = createRadioButton("Verde", 200, 176, groupColoreSfondoTesto, Color.green);
        JRadioButton jButt10 = createRadioButton("Blu", 200, 206, groupColoreSfondoTesto, Color.blue);

        // Creazione JRadioButtons per il colore di sfondo della finestra
        groupColoreSfondoFinestra = new ButtonGroup();
        JRadioButton jButt11 = createRadioButton("Rosso", 320, 86, groupColoreSfondoFinestra, Color.red);
        JRadioButton jButt12 = createRadioButton("Arancione", 320, 116, groupColoreSfondoFinestra, Color.orange);
        JRadioButton jButt13 = createRadioButton("Giallo", 320, 146, groupColoreSfondoFinestra, Color.yellow);
        JRadioButton jButt14 = createRadioButton("Verde", 320, 176, groupColoreSfondoFinestra, Color.green);
        JRadioButton jButt15 = createRadioButton("Blu", 320, 206, groupColoreSfondoFinestra, Color.blue);
        
        groupColoreTesto.add(jButt1);
        groupColoreTesto.add(jButt2);
        groupColoreTesto.add(jButt3);
        groupColoreTesto.add(jButt4);
        groupColoreTesto.add(jButt5);
        groupColoreSfondoTesto.add(jButt6);
        groupColoreSfondoTesto.add(jButt7);
        groupColoreSfondoTesto.add(jButt8);
        groupColoreSfondoTesto.add(jButt9);
        groupColoreSfondoTesto.add(jButt10);
        groupColoreSfondoFinestra.add(jButt11);
        groupColoreSfondoFinestra.add(jButt12);
        groupColoreSfondoFinestra.add(jButt13);
        groupColoreSfondoFinestra.add(jButt14);
        groupColoreSfondoFinestra.add(jButt15);
        
        contentPane.add(jButt1);
        contentPane.add(jButt2);
        contentPane.add(jButt3);
        contentPane.add(jButt4);
        contentPane.add(jButt5);
        contentPane.add(jButt6);
        contentPane.add(jButt7);
        contentPane.add(jButt8);
        contentPane.add(jButt9);
        contentPane.add(jButt10);
        contentPane.add(jButt11);
        contentPane.add(jButt12);
        contentPane.add(jButt13);
        contentPane.add(jButt14);
        contentPane.add(jButt15);
      
    }

    private JRadioButton createRadioButton(String text, int x, int y, ButtonGroup group, Color color) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 100, 26);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    if (group == groupColoreTesto) {
                        txtscritta.setForeground(color);
                    } else if (group == groupColoreSfondoTesto) {
                        txtscritta.setBackground(color);
                    } else if (group == groupColoreSfondoFinestra) {
                        contentPane.setBackground(color);
                    }
                }
            }
        });
        group.add(radioButton);
        contentPane.add(radioButton);
        return radioButton;
    }
}