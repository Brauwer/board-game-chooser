package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.User;
import brauwer.be.boardgamechooser.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@AllArgsConstructor
public class UserController {
  private UserRepository userRepository;

  @PostMapping("user/save")
  User saveUser(@RequestBody User user){
    return userRepository.save(user);
  }

  @GetMapping("user/{id}")
  Optional<User> findUserById(@PathVariable String id) {
    return userRepository.findById(id);
  }

  @GetMapping("user/search/username/{username}")
  Optional<User> findUserByUsername(@PathVariable String username) {
    return userRepository.findByUsername(username);
  }

  @GetMapping("user/search/email/{email}")
  Optional<User> findUserByEmail(@PathVariable String email) {
    return userRepository.findByEmail(email);
  }
}
