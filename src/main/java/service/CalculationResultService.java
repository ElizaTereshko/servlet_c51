package service;

import dbstorage.JDBCResultStorage;
import entity.Operation;
import storage.memory.InMemoryCalculationResultStorage;

import java.time.LocalDateTime;
import java.util.List;

public class CalculationResultService {

//    private InMemoryCalculationResultStorage inMemoryCalculationResultStorage = new InMemoryCalculationResultStorage();
    private final JDBCResultStorage jdbcResultStorage = new JDBCResultStorage();

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

    public void saveCalculationResult ( double result, String userLogin){
        jdbcResultStorage.saveResult(userLogin, result);
    }

    public List<String> getResultHistory (String userLogin){
        return jdbcResultStorage.getResultHistory(userLogin);
    }

    public void deleteResultHistory(String userLogin){
        jdbcResultStorage.deleteResultHistory(userLogin);
    }


}
