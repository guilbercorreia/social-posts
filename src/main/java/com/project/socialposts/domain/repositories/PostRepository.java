package com.project.socialposts.domain.repositories;

import com.project.socialposts.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
