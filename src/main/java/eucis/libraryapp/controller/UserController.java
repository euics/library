package eucis.libraryapp.controller;

import eucis.libraryapp.entity.Users;
import eucis.libraryapp.request.UserCreateRequest;
import eucis.libraryapp.request.UserDeleteRequest;
import eucis.libraryapp.request.UserUpdateRequest;
import eucis.libraryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody UserDeleteRequest request){
        userService.deleteUser(request);
    }
}
