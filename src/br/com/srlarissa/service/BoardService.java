package br.com.srlarissa.service;

import br.com.srlarissa.model.Board;
import br.com.srlarissa.model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {
    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces(){
        return this.board.getSpaces();
    }

    private List<List<Space>> initBoard(Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();
        for(int i = 0; i < BOARD_LIMIT; i++){
            spaces.add(new ArrayList<>());
            for(int j = 0; j < BOARD_LIMIT; j++){
                var positionConfig = gameConfig.get("%s,%s".formatted(i, j));
                var expectedValue = Integer.parseInt(positionConfig.split(",")[0]);
                var isFixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expectedValue, isFixed);
                spaces.get(i).add(currentSpace);
            }
        }

        return spaces;
    }
}
