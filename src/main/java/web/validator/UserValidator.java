package web.validator;

import entity.User;
import storage.memory.InMemoryUserStorage;

public class UserValidator {

    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public boolean existsByLogin (String userLogin) {
        if (inMemoryUserStorage.getByLogin(userLogin) == null) {
            return false;
        }
        return true;
    }

    public boolean passwordIsTrue (String userLogin, String password){
        if (inMemoryUserStorage.getByLogin(userLogin).getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
