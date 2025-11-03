package org.application.template.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.lang.reflect.Field;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String last_name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    public User() {}

    public User(String first_name, String last_name, String email, String password, LocalDateTime createdAt) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("\n");

        output.append(this.getClass().getName());
        output.append("\n");

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            output.append("\n\t");
            output.append(field.getName());
            output.append(": ");
            try {
                output.append(field.get(this));
            } catch (Exception e) {
                System.out.println("Exception in toString: " + e.getMessage());

                throw new RuntimeException(e);
            }
            output.append("\n");
        }
        output.append("\n");

        return output.toString();
    }
}
