package com.serpens.spapi.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User extends BaseModel {
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
