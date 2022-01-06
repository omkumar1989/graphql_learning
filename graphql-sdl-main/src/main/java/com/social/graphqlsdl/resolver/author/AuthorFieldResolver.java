package com.social.graphqlsdl.resolver.author;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.CommentDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.CommentService;
import com.social.graphqlsdl.service.PostService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {
    private final PostService postService;

    private final CommentService  commentService;
    public AuthorFieldResolver(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    public List<PostDto> posts(AuthorDto authorDto) {

        /*return Collections.singletonList(
                PostDto.builder()
                        .id(UUID.randomUUID())
                        .title("Post title")
                        .description("post Description")
                        .authorId(authorDto.getId())
                        .build()
        );*/
        return postService.getAllPostByAuthorId(authorDto.getId());
    }

    public Integer postCount(AuthorDto authorDto){
        return postService.getPostCountByAuthorId(authorDto.getId());
    }

    public List<CommentDto> comments(AuthorDto authorDto, Integer first){
        /*return Collections.singletonList(CommentDto.builder()
                        .id(UUID.randomUUID())
                        .text("random text")
                .build());*/
        return commentService.getFirstFewCommentsByAuthorId(authorDto.getId(),first);
    }

}
