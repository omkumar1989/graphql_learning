package com.social.graphqlsdl.resolver;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.PostService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorFieldResolver implements GraphQLResolver<AuthorDto> {

    public List<PostDto> posts(AuthorDto authorDto) {

        return Collections.singletonList(
                PostDto.builder()
                        .id(UUID.randomUUID())
                        .title("Post title")
                        .description("post Description")
                        .authorId(authorDto.getId())
                        .build()
        );

    }
}
