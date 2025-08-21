package br.com.srlarissa.model;
import java.util.Collection;
import java.util.List;

import static br.com.srlarissa.model.GameStatusEnum.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {
    private final List<List<Space>> spaces;
    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus(){
        if(spaces.stream().flatMap(Collection::stream).noneMatch(
                s -> s.isFixed() && nonNull(s.getCurrentValue()))) return NON_STARTED;

        return spaces.stream().flatMap(Collection::stream).anyMatch(
                s -> isNull(s.getCurrentValue())) ? INCOMPLETE : COMPLETE;
    }

    public boolean hasErrors(){
        if(getStatus() == NON_STARTED) return false;

        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> nonNull(s.getCurrentValue()) &&
                !s.getCurrentValue().equals(s.getExpectedValue()));
    }

    public boolean changeValue(final int col, final int row, final int value){
        var space = spaces.get(col).get(row);

        if(space.isFixed()) return false;

        space.setCurrentValue(value);
        return true;
    }

    public boolean clearValue(final int col, final int row){
        var space = spaces.get(col).get(row);

        if(space.isFixed()) return false;

        space.clearSpace();
        return true;
    }

    public void reset(){
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    public boolean gameHasFinish(){
        return !hasErrors() && getStatus() == COMPLETE;
    }
}
