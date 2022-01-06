package com.social.graphqlsdl.resolver.comment;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.CommentDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.CommentService;
import com.social.graphqlsdl.service.PostService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class CommentFieldResolver implements GraphQLResolver<CommentDto> {

    private final PostService postService;
    private final CommentService commentService;


    public CommentFieldResolver(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }


    public PostDto getPost(CommentDto commentDto){

        return postService.getPostById(commentDto.getPostId());
    }
    public AuthorDto getAuthor(CommentDto commentDto){

        return postService.getAuthorById(commentDto.getAuthorId());
    }


}
