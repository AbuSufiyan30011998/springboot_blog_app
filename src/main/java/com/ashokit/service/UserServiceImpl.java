package com.ashokit.service;

import com.ashokit.entities.User;
import com.ashokit.exceptions.ResourceNotFoundException;
import com.ashokit.payload.UserDto;
import com.ashokit.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto upsertUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user","user id",userId));
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "deleted...!!";
        } else {
            return "no record found..!!";
        }
    }
}
