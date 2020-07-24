package net.microservices.user.application;

import net.microservices.user.gateway.UserService;
import net.microservices.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEndPoints {

    //  User Services
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createEndPoint(@RequestBody User user) {
        userService.create(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(path).build();
    }

    @GetMapping("/user")
    public List<User> findEndPoint() {
        return userService.find();
    }

    @GetMapping("/user/{id}")
    public User findIdEndPoint(@PathVariable String id) {
        return userService.findId(id);
    }

    @PutMapping("/user/{id}")
    public User updateEndPoint(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteEndPoint(@PathVariable String id) {
        return userService.delete(id);
    }
}
