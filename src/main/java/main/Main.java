package main;

import java.awt.Font;

import javax.swing.UIManager;

import utils.*;

public class Main {

  public static void main(String[] args) {
    UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("TextArea.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("CheckBox.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("RadioButton.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 24));

    FileChooser_Interface.main(args);
  }
}
