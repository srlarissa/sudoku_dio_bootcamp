package br.com.srlarissa.ui.custom.screen;

import br.com.srlarissa.model.Space;
import br.com.srlarissa.service.BoardService;
import br.com.srlarissa.ui.custom.button.CheckGameStatusButton;
import br.com.srlarissa.ui.custom.button.FinishGameButton;
import br.com.srlarissa.ui.custom.button.ResetButton;
import br.com.srlarissa.ui.custom.frame.MainFrame;
import br.com.srlarissa.ui.custom.input.NumberText;
import br.com.srlarissa.ui.custom.panel.MainPanel;
import br.com.srlarissa.ui.custom.panel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainScreen {
    private final static Dimension dimension = new Dimension(600, 600);
    private final BoardService boardService;

    private JButton checkGameStatusButton;
    private JButton finishGameButton;
    private JButton resetButton;

    public MainScreen(final Map<String, String> gameConfig){
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);

        for(int r = 0; r < 9; r += 3){
            var endRow = r + 2;
            for(int c = 0; c < 9; c += 3){
                var endCol = c + 2;
                var spaces = getSpacesFromSector(boardService.getSpaces(), c, endCol, r, endRow);
                JPanel sector = generatePanel(spaces);
                mainPanel.add(sector);
            }

        }
        
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishButton(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Space> getSpacesFromSector(final List<List<Space>> spaces,
                                            final int initCol, final int endCol,
                                            final int initRow, final int endRow){

        List<Space> spaceSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++){
            for(int c = initCol; c <= endCol; c++){
                spaceSector.add(spaces.get(c).get(r));
            }
        }
        return spaceSector;
    }

    private JPanel generatePanel(final List<Space> spaces){
        List<NumberText> fields = new ArrayList<>(spaces.stream().map(NumberText::new).toList());
        return new SudokuSector(fields);
    }

    private void addFinishButton(final JPanel mainPanel) {
        finishGameButton = new FinishGameButton(e -> {
            if(boardService.gameIsFinished()){
                JOptionPane.showMessageDialog(null, "Parabéns! Você concluiu o jogo!");
                resetButton.setEnabled(false);
                finishGameButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(
                        null,
                        "Seu jogo ainda tem alguma inconsistência. Tente novamente.");
            }
        });
        mainPanel.add(finishGameButton);
    }

    private void addCheckGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new CheckGameStatusButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();

            var message = switch(gameStatus){
                case COMPLETE -> "O jogo não foi completado";
                case INCOMPLETE -> "O jogo ainda não acabou";
                case NON_STARTED -> "O jogo ainda não iniciou";
            };

            message += hasErrors ? " e contém erros" : " e não contém erros";
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addResetButton(final JPanel mainPanel) {
        resetButton = new ResetButton(e ->{
            var dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja reiniciar o jogo?",
                    "Limpar o jogo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if(dialogResult == 0) boardService.reset();
        });
        mainPanel.add(resetButton);
    }

}
