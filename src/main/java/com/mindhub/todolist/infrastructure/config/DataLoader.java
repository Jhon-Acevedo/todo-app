package com.mindhub.todolist.infrastructure.config;

import com.mindhub.todolist.infrastructure.user.adapter.entity.RolEntity;
import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IRolAdapterRepositoryJPA;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IUserAdapterRepositoryJPA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(IRolAdapterRepositoryJPA rolRepository, IUserAdapterRepositoryJPA userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!rolRepository.existsById(1L)) {
                RolEntity userRole = new RolEntity();
                userRole.setId(1L);
                userRole.setName("ADMIN");
                rolRepository.save(userRole);
            }

            if (!rolRepository.existsById(2L)) {
                RolEntity adminRole = new RolEntity();
                adminRole.setId(2L);
                adminRole.setName("USER");
                rolRepository.save(adminRole);
            }

        };
    }
}