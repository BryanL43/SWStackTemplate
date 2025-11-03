package org.application.template.dto;

import java.time.LocalDateTime;

public record UserDto(
    Integer id,
    String first_name,
    String last_name,
    String email,
    LocalDateTime createdAt
) {}
