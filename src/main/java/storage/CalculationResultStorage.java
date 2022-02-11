package storage;

import java.util.List;

public interface CalculationResultStorage {

    void saveResult (String userLogin, String result);
    List <String> getResultHistory(String userLogin);
    void deleteResultHistory (String userLogin);

}
