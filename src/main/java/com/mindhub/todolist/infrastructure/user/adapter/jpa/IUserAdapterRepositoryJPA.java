package com.mindhub.todolist.infrastructure.user.adapter.jpa;

import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserAdapterRepositoryJPA extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
