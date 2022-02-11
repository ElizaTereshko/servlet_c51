package service;

import entity.Operation;
import storage.memory.InMemoryCalculationResultStorage;

import java.time.LocalDateTime;
import java.util.List;

public class CalculationResultService {

    private InMemoryCalculationResultStorage inMemoryCalculationResultStorage = new InMemoryCalculationResultStorage();

    public double calculate (Operation operation){
        double result = 0;
        double theFirstValue = Double.parseDouble(operation.getTheFirstValue());
        double theSecondValue = Double.parseDouble(operation.getTheSecondValue());

        switch (operation.getOperation()){
            case ("+"):
                result = theFirstValue + theSecondValue;
                break;
            case ("-"):
                result = theFirstValue- theSecondValue;
                break;
            case ("*"):
                result = theFirstValue * theSecondValue;
                break;
            case ("/"):
                result = theFirstValue / theSecondValue;
                break;
        }
        return result;
    }

    public void saveCalculationResult (Operation operation, double result, String userLogin){
        String saveResult = operation.getTheFirstValue() + " " + operation.getOperation() + " " + operation.getTheSecondValue() + " = "
                + result + " " + LocalDateTime.now();
        inMemoryCalculationResultStorage.saveResult(userLogin, saveResult);
    }

    public List<String> getResultHistory (String userLogin){
        return inMemoryCalculationResultStorage.getResultHistory(userLogin);
    }

    public void deleteResultHistory(String userLogin){
        inMemoryCalculationResultStorage.deleteResultHistory(userLogin);
    }


}
