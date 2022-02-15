package storage.memory;

import storage.CalculationResultStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCalculationResultStorage implements CalculationResultStorage {

   final static List <String> listCalculationResult = new ArrayList<>();


    private final static Map <String, List<String> > calculationResultStorage = new ConcurrentHashMap<>();

    @Override
    public void saveResult(String userLogin, double result) {
//            listCalculationResult.add(result);
            calculationResultStorage.remove(userLogin);
            calculationResultStorage.putIfAbsent(userLogin, listCalculationResult);
    }

    @Override
    public List<String> getResultHistory(String userLogin) {
        return calculationResultStorage.get(userLogin);
    }

    @Override
    public void deleteResultHistory(String userLogin) {
        calculationResultStorage.remove(userLogin);
    }
}
