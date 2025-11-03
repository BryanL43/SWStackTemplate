package org.application.template.dto;

public record UserMutationResponseDto(
    boolean success,
    String message,
    UserDto user
) {}
