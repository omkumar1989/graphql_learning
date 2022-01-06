package com.social.graphqlsdl.resolver.comment;

import com.social.graphqlsdl.dto.CommentDto;
import com.social.graphqlsdl.service.CommentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentQueryResolver implements GraphQLQueryResolver {

    private final CommentService commentService;

    public CommentQueryResolver(CommentService commentService) {
        this.commentService = commentService;
    }


    public List<CommentDto> comments(Integer count,Integer offset){

        /*return Collections.singletonList(AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Om KUmar")
                .email("om.kumar@gmail.com")
                .build());*/ //direct

        //from db
        return commentService.getComments(count,offset);
    }

}
