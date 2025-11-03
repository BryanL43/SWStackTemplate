package org.application.template.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import org.application.template.entity.User;
import org.application.template.repository.UserRepository;
import org.application.template.dto.UserDto;
import org.application.template.dto.UserInputDto;
import org.application.template.dto.UserMutationResponseDto;

@Service
@Transactional(rollbackFor = Exception.class)
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

    public UserMutationResponseDto createUser(UserInputDto input) {
        try {
            User user = new User();
            user.setFirstName(input.first_name());
            user.setLastName(input.last_name());
            user.setEmail(input.email());
            user.setPassword(input.password());

            User newUser = userRepository.save(user);
            return new UserMutationResponseDto(
                true,
                "Account created successfully",
                toView(newUser)
            );
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new UserMutationResponseDto(
                false,
                "Account creation failed: " + e.getMessage(),
                null
            );
        }
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
