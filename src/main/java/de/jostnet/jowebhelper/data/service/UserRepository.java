package de.jostnet.jowebhelper.data.service;

import de.jostnet.jowebhelper.data.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}