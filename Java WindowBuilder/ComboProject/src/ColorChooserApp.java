import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserApp {

    private static JComboBox<String> cbocolore;
    private static JTextField txtscritta;
    private static JLabel lblcolore;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Color Chooser App");
        frame.setLayout(null);

        // Creazione JComboBox
        cbocolore = new JComboBox<>();
        cbocolore.setBounds(83, 86, 93, 26);
        cbocolore.addItem("rosso");
        cbocolore.addItem("arancione");
        cbocolore.addItem("giallo");
        cbocolore.addItem("verde");
        cbocolore.addItem("blu");
        frame.getContentPane().add(cbocolore);

        // Creazione JTextField
        txtscritta = new JTextField("ciao mondo");
        txtscritta.setBounds(83, 150, 150, 26);
        frame.getContentPane().add(txtscritta);

        // Creazione JLabel
        lblcolore = new JLabel();
        lblcolore.setBounds(83, 200, 200, 26);
        frame.getContentPane().add(lblcolore);

        // Gestione evento JComboBox
        cbocolore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color colore = Color.black;
                switch (cbocolore.getSelectedIndex()) {
                    case 0:
                        colore = Color.red;
                        break;
                    case 1:
                        colore = Color.orange;
                        break;
                    case 2:
                        colore = Color.yellow;
                        break;
                    case 3:
                        colore = Color.green;
                        break;
                    case 4:
                        colore = Color.blue;
                        break;
                }
                txtscritta.setForeground(colore);
                String testo = "Hai scelto " + cbocolore.getSelectedItem();
                lblcolore.setText(testo);
            }
        });

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
