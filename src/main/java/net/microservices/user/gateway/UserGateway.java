package net.microservices.user.gateway;

import net.microservices.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserGateway {

    List<User> userList = new ArrayList<>();
    public List<User> find() {
        return userList;
    }

    public User findId(String id) {
        Optional<User> first = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        } else {
            return new User();
        }
    }

    public void create(User user) {
        userList.add(user);
    }

    public User update(User user) {
        for (User u : userList) {
            u.setLastName(user.getLastName());
            u.setFirstName(user.getFirstName());
            u.setDni(user.getDni());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setState(user.getState());
            return u;
        }
        return new User();
    }

    public User delete(String id) {
        Optional<User> first = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (first.isPresent()) {
            User u = first.get();
            userList.remove(u);
            return u;
        } else {
            return new User();
        }
    }
}
