package com.mindhub.todolist.infrastructure.task.adapter.entity;

import com.mindhub.todolist.domain.task.model.entity.Status;
import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Status status;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private UserEntity userEntity;

    public TaskEntity(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

}
