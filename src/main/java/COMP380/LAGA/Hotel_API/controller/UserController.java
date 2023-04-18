package COMP380.LAGA.Hotel_API.controller;

import COMP380.LAGA.Hotel_API.model.User;
import COMP380.LAGA.Hotel_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The UserController class represents a RESTful API controller for handling user-related requests.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a list of all users from the user repository.
     *
     * @return A ResponseEntity containing the list of users and an HTTP status code indicating the success of the operation.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Retrieves a specific user from the user repository based on its ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return A ResponseEntity containing the user and an HTTP status code indicating the success of the operation.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Adds a new user to the user repository.
     *
     * @param user The user object to be added.
     * @return A ResponseEntity containing the created user and an HTTP status code indicating the success of the operation.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /**
     * Updates an existing user in the user repository based on its ID.
     *
     * @param userId The ID of the user to update.
     * @param user The updated user object.
     * @return A ResponseEntity containing the updated user and an HTTP status code indicating the success of the operation.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setAddress(user.getAddress());
            userRepository.save(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing user from the user repository based on its ID.
     *
     * @param userId The ID of the user to delete.
     * @return A ResponseEntity with no content and an HTTP status code indicating the success of the operation.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
