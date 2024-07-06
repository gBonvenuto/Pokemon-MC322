package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FileChooser_Interface extends JFrame {

  private File path = null;

  public FileChooser_Interface() {
    setTitle("Escolha o arquivo de Log");
    setSize(800, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(gridbag);

    c.gridwidth = GridBagConstraints.REMAINDER;
    JLabel title = new JLabel("Selecione a pasta para a qual o log será gravado");
    add(title, c);

    c.fill = GridBagConstraints.BOTH;
    c.gridwidth = GridBagConstraints.RELATIVE;
    JTextArea path_TextArea = new JTextArea();
    path_TextArea.setEditable(false);
    path_TextArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    path_TextArea.setPreferredSize(new Dimension(500, 20));
    path_TextArea.setToolTipText("path");
    add(path_TextArea, c);

    c.gridwidth = GridBagConstraints.REMAINDER;
    JButton selecionar_Button = new JButton();
    selecionar_Button.setText("Selecionar pasta");
    add(selecionar_Button, c);

    JButton confirmar_Button = new JButton();
    confirmar_Button.setText("Confirmar");
    add(confirmar_Button, c);

    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    JFrame parent = this;

    selecionar_Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          path = chooser.getSelectedFile();
          path_TextArea.setText(path.toString());
        }
      }
    });

    confirmar_Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (path == null) {
          JOptionPane.showMessageDialog(parent,
              "Por favor, Selecione uma pasta para o log.", "Erro", JOptionPane.ERROR_MESSAGE);
          return;
        }
        Savelog.setPath(path);
        Savelog.log("O arquivo "+Savelog.getPath().toString()+ "Foi definido para o log");
        InicializarJogador_Interface.main(null);
        dispose();
      }
    });

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        FileChooser_Interface interface1 = new FileChooser_Interface();
        interface1.setVisible(true);
      }
    });
  }
}
