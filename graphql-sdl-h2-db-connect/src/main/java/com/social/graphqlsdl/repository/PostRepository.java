package com.social.graphqlsdl.repository;

import com.social.graphqlsdl.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByAuthor_Id(UUID authorId);
}
