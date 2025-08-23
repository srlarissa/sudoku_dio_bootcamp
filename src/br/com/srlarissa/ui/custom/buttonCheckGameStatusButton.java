package br.com.srlarissa.ui.custom;

import javax.swing.*;

public class buttonCheckGameStatusButton extends JButton {
    public buttonCheckGameStatusButton(){
        this.setText("VERIFICAR JOGO");
        this.addActionListener(actionListener);
    }
}
