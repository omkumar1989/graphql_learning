package com.social.graphqlsdl.service;

import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<PostDto> getAllPostByAuthorId(UUID authorId);
}
