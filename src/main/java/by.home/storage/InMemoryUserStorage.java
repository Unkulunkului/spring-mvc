package by.home.storage;

import by.home.entity.User;
import by.home.service.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private static int id = 0;
    private List<User> userList = new ArrayList<>();

    public void save (User user){
        if(!contains(user)){
            user.setId(id++);
            userList.add(user);
        }else {
            throw new UserNotFoundException("User is already exist");
        }
    }

    public User getByLogin(String login){
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found!");
    }

    public boolean contains(User user){
        for (User u : userList) {
            if(u.equals(user)){
                return true;
            }
        }
        return false;
    }
}
