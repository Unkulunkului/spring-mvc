package by.home.service;

import by.home.entity.User;
import by.home.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public void addUser(User user){
        inMemoryUserStorage.save(user);
    }


    public User getByLogin (User user){
        User byLogin = inMemoryUserStorage.getByLogin(user.getLogin());
        if(byLogin != null){
            return byLogin;
        }
        return null;
    }

    public boolean checkPassword(User user, String password){
        return user.getPassword().equals(password);
    }
}
