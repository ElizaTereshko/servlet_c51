package service;

import dbstorage.JDBCUserStorage;
import entity.User;
import storage.memory.InMemoryUserStorage;

public class UserService {

    private final JDBCUserStorage jdbcUserStorage = new JDBCUserStorage();

    public void saveUser (User user){
        jdbcUserStorage.saveUser(user);
    }

    public User getByLogin (String userLogin){
       return jdbcUserStorage.getByLogin(userLogin);
    }

    //    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

//    public void saveUser (User user){
//        inMemoryUserStorage.saveUser(user);
//    }
//
//    public User getByLogin (String userLogin){
//       return inMemoryUserStorage.getByLogin(userLogin);
//    }

}
