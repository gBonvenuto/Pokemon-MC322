package utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Batalha_Interface extends JFrame {
    private Icon pokemon1;
    private Icon pokemon2;
    JFrame batalha = new JFrame("Batalha");
    batalha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    batalha.setSize(600, 400);
    batalha.setLayout(new BorderLayout());

    public Batalha_Interface() {
        JButton atacar = new JButton("Atacar");
        JButton passa = new JButton("Passa a vez");
        JButton troca = new JButton("Troca");
    }
}
