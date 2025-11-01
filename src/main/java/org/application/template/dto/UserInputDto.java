package org.application.template.dto;

public record UserInputDto(
    String first_name,
    String last_name,
    String email,
    String password
) {}
