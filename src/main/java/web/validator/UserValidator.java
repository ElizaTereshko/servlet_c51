package web.validator;

import dbstorage.JDBCUserStorage;
import entity.User;
import storage.memory.InMemoryUserStorage;

public class UserValidator {
    private final JDBCUserStorage jdbcUserStorage = new JDBCUserStorage();


    public boolean existsByLogin (String userLogin) {
        if (jdbcUserStorage.getByLogin(userLogin) == null) {
            return false;
        }
        return true;
    }

    public boolean passwordIsTrue (String userLogin, String password){
        if (jdbcUserStorage.getByLogin(userLogin).getPassword().equals(password)){
            return true;
        }
        return false;
    }

//    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
//
//
//    public boolean existsByLogin (String userLogin) {
//        if (inMemoryUserStorage.getByLogin(userLogin) == null) {
//            return false;
//        }
//        return true;
//    }
//
//    public boolean passwordIsTrue (String userLogin, String password){
//        if (inMemoryUserStorage.getByLogin(userLogin).getPassword().equals(password)){
//            return true;
//        }
//        return false;
//    }
}
