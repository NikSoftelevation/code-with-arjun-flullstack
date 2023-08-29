package com.code.with.arjun.controller;

import com.code.with.arjun.dto.UserDto;
import com.code.with.arjun.entity.User;
import com.code.with.arjun.response.ApiResponse;
import com.code.with.arjun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/user")
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody User user, @PathVariable("userId") int userId) {

        return new ResponseEntity<>(userService.updateUser(user, userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserByUserId(@PathVariable("userId") int userId) {

        return new ResponseEntity<>(userService.getUserByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int userId) {

        userService.deleteUser(userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully"), HttpStatus.GONE);
    }

}
