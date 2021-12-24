package com.social.graphqlsdl.resolver;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.AuthorService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {



    public AuthorDto getAuthor(PostDto postDto){
      return   AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Om KUmar")
                .email("om.kumar@gmail.com")
                .build();

    }
}
