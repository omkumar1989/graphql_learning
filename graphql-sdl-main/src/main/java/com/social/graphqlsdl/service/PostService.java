package com.social.graphqlsdl.service;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<PostDto> getAllPostByAuthorId(UUID authorId);

    UUID createPost(PostDto postDto);

    List<PostDto> getRecentPosts(int count, int offset);

    Integer getPostCountByAuthorId(UUID id);

    PostDto getPostById(UUID postId);

    AuthorDto getAuthorById(UUID authorId);
}
