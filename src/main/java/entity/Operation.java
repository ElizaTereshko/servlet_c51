package entity;

public class Operation {
    private String theFirstValue;
    private String theSecondValue;
    private String operation;

    public Operation() {
    }

    public Operation(String theFirstValue, String theSecondValue, String operation) {
        this.theFirstValue = theFirstValue;
        this.theSecondValue = theSecondValue;
        this.operation = operation;
    }

    public String getTheFirstValue() {
        return theFirstValue;
    }

    public String getTheSecondValue() {
        return theSecondValue;
    }

    public String getOperation() {
        return operation;
    }

    public void setTheFirstValue(String theFirstValue) {
        this.theFirstValue = theFirstValue;
    }

    public void setTheSecondValue(String theSecondValue) {
        this.theSecondValue = theSecondValue;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "theFirstValue='" + theFirstValue + '\'' +
                ", theSecondValue='" + theSecondValue + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
