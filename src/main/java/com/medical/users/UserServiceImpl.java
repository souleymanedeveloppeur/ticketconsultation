package com.medical.users;

import com.medical.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public List<UserDto> allUsers() {
        return new ArrayList<>(mapper.toDto(userRepository.findAll()));
    }
}
