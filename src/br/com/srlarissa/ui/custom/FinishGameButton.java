package br.com.srlarissa.ui.custom;

import javax.swing.*;

public class FinishGameButton extends JButton {
    public FinishGameButton(){
        this.setText("CONCLUIR JOGO");
        this.addActionListener(actionListener);
    }
}

