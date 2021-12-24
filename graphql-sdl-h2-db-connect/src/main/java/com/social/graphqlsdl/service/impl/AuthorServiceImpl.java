package com.social.graphqlsdl.service.impl;

import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.model.Author;
import com.social.graphqlsdl.repository.AuthorRepository;
import com.social.graphqlsdl.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAuthors() {
        List<Author> all = authorRepository.findAll();
        return all.stream().map(author -> {
            return AuthorDto.builder()
                    .id(author.getId())
                    .email(author.getEmail())
                    .name(author.getName())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(UUID authorId) {
        Author author = authorRepository.findById(authorId).get();
        return AuthorDto.builder()
                .id(author.getId())
                .email(author.getEmail())
                .name(author.getName())
                .build();

    }


}
