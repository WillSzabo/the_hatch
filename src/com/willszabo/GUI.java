package com.willszabo;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.text.Caret;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener {

    // FIELDS
    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static JLabel labelRightArrow = new JLabel("〉");
    public static JLabel labelColon = new JLabel(":");
    public static Color lightBlack = new Color(26, 26, 26);
    public static JTextField userText = new JTextField();
    public static String enteredNumbers;


    //Constructor
    public GUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        SwanConsole swanConsole = new SwanConsole();


        //TEXT FIELD - Must come before labels are added, or it won't have focus.
        userText.setBounds(25, 25, 500, 25);
        userText.setBackground(lightBlack);
        userText.setBorder(null);
        userText.setForeground(Color.GREEN);
        userText.setCaretColor(Color.GREEN);
        Caret myCaret = new FatCaret();
        userText.setCaret(myCaret);
        userText.getCaret().setBlinkRate(800);
        userText.getCaret().setVisible(true);
        
        
        /*
         * This is where the magic happens. Make userText field listen for an action, when action 
         * occurs (return/enter key is hit) run event, calling checkTheNumbers function from the 
         * swanConsole class, which verifies numbers and resets count down timers and alarm.
         */
        userText.addActionListener( e -> swanConsole.checkTheNumbers(userText.getText()));

        
        // Add userText and labels to panel, userText must be added first to have focus on startup.
        panel.add(userText);
        panel.add(labelRightArrow);
        panel.add(labelColon);
        
 
        // PANEL - Configuration
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);
        panel.setBackground(lightBlack);
        
        
        // FRAME
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Welcome to the Swan Station");


        // LABEL
        labelRightArrow.setForeground(Color.GREEN);
        labelRightArrow.setBounds(10, 25, 80, 25);
        labelRightArrow.setFont(new Font("", Font. BOLD, 14));
        labelColon.setForeground(Color.GREEN);
        labelColon.setBounds(17, 24, 80, 25);
        labelColon.setFont(new Font("", Font.BOLD, 14));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
