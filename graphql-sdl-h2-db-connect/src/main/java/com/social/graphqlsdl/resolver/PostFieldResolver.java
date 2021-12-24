package com.social.graphqlsdl.resolver;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.AuthorService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {

    private final AuthorService authorService;

    public PostFieldResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public AuthorDto getAuthor(PostDto postDto){
     /* return   AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Om KUmar")
                .email("om.kumar@gmail.com")
                .build();*/
        return authorService.getAuthorById(postDto.getAuthorId());
    }
}
