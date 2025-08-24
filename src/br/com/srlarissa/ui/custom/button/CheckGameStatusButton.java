package br.com.srlarissa.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CheckGameStatusButton extends JButton {
    public CheckGameStatusButton(ActionListener action){
        this.setText("VERIFICAR JOGO");
        this.addActionListener(actionListener);
    }
}
