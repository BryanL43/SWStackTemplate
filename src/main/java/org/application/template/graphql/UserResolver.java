package org.application.template.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import org.application.template.dto.UserDto;
import org.application.template.service.UserService;

@Controller
public class UserResolver {
    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public UserDto userById(@Argument Integer id) {
        return userService.getById(id);
    }
}
