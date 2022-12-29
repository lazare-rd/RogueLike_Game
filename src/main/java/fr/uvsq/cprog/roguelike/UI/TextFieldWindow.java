package fr.uvsq.cprog.roguelike.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread;

public class TextFieldWindow extends JFrame implements ActionListener{
    private JTextField textField ;
    private JButton saveButton = new JButton("Save");
    private String data ;
    private JPanel myPanel ;
    private boolean userHasCliked ;

    public TextFieldWindow() {
        this.myPanel = new JPanel();
        this.userHasCliked = false ;
        add(myPanel);
        myPanel.setLayout(new GridLayout(3, 2));
        textField = new JTextField();
        myPanel.add(textField);
        myPanel.add(saveButton);
        saveButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == saveButton) {
            try {
                this.data = textField.getText();
                this.userHasCliked = true ;
                Thread.sleep(100);
                this.dispose(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getData() {
        return this.data ;
    }

    public boolean getUserHasCliked() {
        return this.userHasCliked ;
    }

    public void showWindow() {
        this.setLocation(10, 10);
        this.setSize(300, 300);
        this.setVisible(true);
    }
}
