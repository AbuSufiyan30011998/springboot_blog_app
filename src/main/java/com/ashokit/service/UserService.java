package com.ashokit.service;

import com.ashokit.entities.User;
import com.ashokit.payload.UserDto;

import java.util.List;

public interface UserService {



    UserDto upsertUser(UserDto userDto);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();

    String deleteUser(Long userId);

}
