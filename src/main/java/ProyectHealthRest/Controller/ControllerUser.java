package ProyectHealthRest.Controller;

import ProyectHealthRest.Entities.User;
import ProyectHealthRest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerUser {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public List<User> userList(User request){
       return userService.userList();
    }
    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody User request)throws Exception{
        this.userService.CreateUser(request);
        return "user was created";
    }
    @PutMapping(value = "/upDateUser/{id}")
    public String upDateUser(@PathVariable Long id,@RequestBody User request)throws Exception{
        this.userService.updateUser(id, request);
        return "user was updated";
    }
    @DeleteMapping(value ="/deleteUser")
    public String deleteUser(@PathVariable Long id)throws Exception{
        this.userService.deleteById(id);
        return "user was deleted";
    }
}
