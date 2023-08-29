package com.code.with.arjun.service;

import com.code.with.arjun.dto.UserDto;
import com.code.with.arjun.entity.User;

import java.util.List;

public interface UserService {
    public UserDto createUser(User user);

    public UserDto updateUser(User user, int userId);

    public UserDto getUserByUserId(int userId);

    public List<UserDto> getAllUsers();

    public void deleteUser(int userId);
}
