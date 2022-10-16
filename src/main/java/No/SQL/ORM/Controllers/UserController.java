package No.SQL.ORM.Controllers;

import No.SQL.ORM.Entities.User;
import No.SQL.ORM.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User createTheUser(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/count")
    public long count(@PathVariable String id) throws Exception{
        return userRepository.count();
    }


    @GetMapping("/{id}")
    public User getUsersWithId(@PathVariable String id) throws Exception{
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new Exception("User is not a found");
        }
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable String id, @RequestBody User user) throws Exception{
        if(!userRepository.existsById(id)) throw new Exception("User is not a found");
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
