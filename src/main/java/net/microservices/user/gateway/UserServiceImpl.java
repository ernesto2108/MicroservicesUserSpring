package net.microservices.user.gateway;

import net.microservices.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserGateway userGateway;

    @Override
    public void create(User user) {
        userGateway.create(user);
    }

    @Override
    public List<User> find() {
        return userGateway.find();
    }

    @Override
    public User findId(String id) {
        return userGateway.findId(id);
    }

    @Override
    public User update(User user) {
        return userGateway.update(user);
    }

    @Override
    public User delete(String id) {
        return userGateway.delete(id);
    }
}
