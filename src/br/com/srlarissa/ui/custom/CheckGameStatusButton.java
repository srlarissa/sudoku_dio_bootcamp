package br.com.srlarissa.ui.custom;

import javax.swing.*;

public class CheckGameStatusButton extends JButton {
    public CheckGameStatusButton(){
        this.setText("VERIFICAR JOGO");
        this.addActionListener(actionListener);
    }
}
