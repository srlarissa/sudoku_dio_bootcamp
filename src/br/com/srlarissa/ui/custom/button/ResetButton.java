package br.com.srlarissa.ui.custom.button;

import javax.swing.*;

public class ResetButton extends JButton {
    public ResetButton(){
        this.setText("REINICIANDO O JOGO");
        this.addActionListener(actionListener);
    }
}
