package com.social.graphqlsdl.service.impl;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.model.Post;
import com.social.graphqlsdl.repository.PostRepository;
import com.social.graphqlsdl.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getAllPostByAuthorId(UUID authorId) {
        List<Post> allByAuthor_id=postRepository.findAllByAuthor_Id(authorId) ;
        return allByAuthor_id.stream()
                .map(post -> {
                    return  PostDto.builder()
                            .id(post.getId())
                            .authorId(authorId)
                            .description(post.getDescription())
                            .title(post.getTitle())
                            .category(post.getCategory())
                            .build();
                }).collect(Collectors.toList());
    }
}
