package com.social.graphqlsdl.service;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<AuthorDto> getAuthors();

    AuthorDto getAuthorById(UUID authorId);
}
