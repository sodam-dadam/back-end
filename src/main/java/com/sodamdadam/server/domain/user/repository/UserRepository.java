package com.sodamdadam.server.domain.user.repository;

import com.sodamdadam.server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndPassword(String id, String password);
}
