package service;

import entity.User;
import storage.memory.InMemoryUserStorage;

public class UserService {

    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public void saveUser (User user){
        inMemoryUserStorage.saveUser(user);
    }

    public User getByLogin (String userLogin){
       return inMemoryUserStorage.getByLogin(userLogin);
    }

}
