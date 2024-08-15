package com.mindhub.todolist.infrastrcuture.user.adapter.jpa;

import com.mindhub.todolist.infrastrcuture.user.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAdapterRepositoryJPA extends JpaRepository<UserEntity, Long> {
}
