package br.com.srlarissa.ui.custom.button;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {
    public ResetButton(ActionListener actionListener){
        this.setText("REINICIANDO O JOGO");
        this.addActionListener(actionListener);
    }
}
