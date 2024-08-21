package com.mindhub.todolist.infrastructure.config;

import com.mindhub.todolist.application.user.command.UserCreateHandler;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import com.mindhub.todolist.infrastructure.user.adapter.entity.RolEntity;
import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IRolAdapterRepositoryJPA;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IUserAdapterRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class DataLoader {

    private final UserCreateHandler userCreateHandler;

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
//            UserCreateCommand adminUserCommand = new UserCreateCommand(
//                    "admin",
//                    passwordEncoder.encode("admin_password"),
//                    "admin@example.com",
//                    1L
//            );
//            UserDto adminUser = userCreateHandler.execute(adminUserCommand);
//            System.out.println(adminUser.toString());
        };
    }
}