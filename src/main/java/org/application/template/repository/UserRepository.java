package org.application.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.application.template.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Declare custom queries here, e.g. findByX()
}
