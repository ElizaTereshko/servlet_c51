package storage.memory;

import entity.User;
import storage.UserStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserStorage implements UserStorage {

    private final static Map <String, User> userStorage = new ConcurrentHashMap<>();

    @Override
    public void saveUser(User user) {
        userStorage.put(user.getLogin(), user);
    }

    @Override
    public User getByLogin(String userLogin) {
        return userStorage.get(userLogin);
    }
}
