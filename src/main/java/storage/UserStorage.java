package storage;

import entity.User;

public interface UserStorage {

    void saveUser (User user);
    User getByLogin (String userLogin);

}
