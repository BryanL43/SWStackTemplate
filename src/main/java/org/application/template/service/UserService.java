package org.application.template.service;

import org.application.template.entity.User;
import org.application.template.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.application.template.dto.UserDto;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getById(Integer id) {
        return userRepository.findById(id)
            .map(this::toView)
            .orElse(null);
    }

    private UserDto toView(User user) {
        return new UserDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getCreatedAt()
        );
    }
}
