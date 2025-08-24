package br.com.srlarissa.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {
    public ResetButton(ActionListener action){
        this.setText("REINICIANDO O JOGO");
        this.addActionListener(actionListener);
    }
}
