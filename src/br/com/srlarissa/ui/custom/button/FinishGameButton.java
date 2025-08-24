package br.com.srlarissa.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FinishGameButton extends JButton {
    public FinishGameButton(ActionListener action){
        this.setText("CONCLUIR JOGO");
        this.addActionListener(actionListener);
    }
}

