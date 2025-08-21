package br.com.srlarissa.model;

public class Space {
    private Integer currentValue;
    private final int expectedValue;
    private final boolean fixed;

    public Space(int expectedValue, boolean canBeAltered) {
        this.expectedValue = expectedValue;
        this.fixed = canBeAltered;

        if(fixed) currentValue = expectedValue;
    }

    public boolean isFixed() {
        return fixed;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        if(fixed) return;
        this.currentValue = currentValue;
    }

    public void clearSpace(){
        setCurrentValue(null);
    }
}
