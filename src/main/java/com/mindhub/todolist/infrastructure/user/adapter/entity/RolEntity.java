package com.mindhub.todolist.infrastructure.user.adapter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "rol")
@NoArgsConstructor
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RolEntity(Long id, String name) {
    }

    public RolEntity(String name) {
        this.name = name;
    }

}
