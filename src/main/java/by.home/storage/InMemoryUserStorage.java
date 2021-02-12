package by.home.storage;

import by.home.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private static int id = 0;
    private List<User> userList = new ArrayList<>();

    public boolean save (User user){
        if(!userList.contains(user)){
            user.setId(id++);
            userList.add(user);
            return true;
        }
        return false;
    }

    public User getByLogin(String login){
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
