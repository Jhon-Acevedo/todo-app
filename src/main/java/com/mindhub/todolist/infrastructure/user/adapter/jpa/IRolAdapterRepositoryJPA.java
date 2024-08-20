package com.mindhub.todolist.infrastructure.user.adapter.jpa;

import com.mindhub.todolist.infrastructure.user.adapter.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolAdapterRepositoryJPA extends JpaRepository<RolEntity, Long> {
}
