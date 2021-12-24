package com.social.graphqlsdl.resolver;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.service.AuthorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorService authorService;


    public AuthorQueryResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<AuthorDto> getAuthors(){

        /*return Collections.singletonList(AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Om KUmar")
                .email("om.kumar@gmail.com")
                .build());*/ //direct

        //from db
        return authorService.getAuthors();
    }

}
