package net.microservices.user.gateway;

import net.microservices.user.domain.User;

import java.util.List;

public interface UserService {

    void create(User user);
    List<User> find();
    User findId(String id);
    User update(User user);
    User delete(String id);
}
