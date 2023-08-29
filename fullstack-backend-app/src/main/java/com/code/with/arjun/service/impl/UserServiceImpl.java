package com.code.with.arjun.service.impl;

import com.code.with.arjun.dto.UserDto;
import com.code.with.arjun.entity.User;
import com.code.with.arjun.exception.UserNotFoundException;
import com.code.with.arjun.repository.UserRepository;
import com.code.with.arjun.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(User user) {

        User createdUser = userRepository.save(user);

        return modelMapper.map(createdUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(User user, int userId) {

        User userRepositoryById = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with userId " + userId + "not found"));

        userRepositoryById.setId(user.getId());
        userRepositoryById.setEmail(user.getEmail());
        userRepositoryById.setName(user.getName());
        userRepositoryById.setUsername(user.getUsername());

        User updatedUser = userRepository.save(userRepositoryById);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(int userId) {

        User userRepositoryById = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with userId " + userId + "not found"));

        return modelMapper.map(userRepositoryById, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        try {
            List<User> userRepositoryAll = userRepository.findAll();
            return userRepositoryAll.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        throw new UserNotFoundException("there are no users created in database");
    }

    @Override
    public void deleteUser(int userId) {

        userRepository.deleteById(userId);
    }
}
