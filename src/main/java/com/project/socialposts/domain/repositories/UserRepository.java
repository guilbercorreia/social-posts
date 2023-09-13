package com.project.socialposts.domain.repositories;

import com.project.socialposts.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
