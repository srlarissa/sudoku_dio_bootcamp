package br.com.srlarissa.ui.custom.button;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class FinishGameButton extends JButton {
    public FinishGameButton(final ActionListener actionListener){
        this.setText("CONCLUIR JOGO");
        this.addActionListener(actionListener);
    }
}

