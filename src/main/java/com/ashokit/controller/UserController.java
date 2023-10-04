package com.ashokit.controller;

import com.ashokit.payload.UserDto;
import com.ashokit.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto){
        UserDto upserted = userService.upsertUser(userDto);
        return  new ResponseEntity<>(upserted, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));
    }


    @GetMapping("/user")
    public ResponseEntity<List<UserDto>>getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userDto){
        UserDto upserted = userService.upsertUser(userDto);
        return  new ResponseEntity<>(upserted, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUSer(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
    }




}
