package com.mindhub.todolist.infrastructure.user.adapter.entity;

import com.mindhub.todolist.domain.user.model.entity.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String username, password, email;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private RolEntity rol;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email, RolEntity rol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

}
