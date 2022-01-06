package com.social.graphqlsdl.resolver.post;

import com.social.graphqlsdl.context.DataLoaderRegistryFactory;
import com.social.graphqlsdl.dto.AuthorDto;
import com.social.graphqlsdl.dto.CommentDto;
import com.social.graphqlsdl.dto.PostDto;
import com.social.graphqlsdl.service.AuthorService;
import com.social.graphqlsdl.service.CommentService;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class PostFieldResolver implements GraphQLResolver<PostDto> {

    private final AuthorService authorService;
    private final CommentService commentService;
    private final ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime()
            .availableProcessors());
    public PostFieldResolver(AuthorService authorService, CommentService commentService) {
        this.authorService = authorService;
        this.commentService = commentService;
    }
//without CompletableFuture synco call
 /*   public AuthorDto getAuthor(PostDto postDto){
       
     *//* return   AuthorDto.builder()
                .id(UUID.randomUUID())
                .name("Om KUmar")
                .email("om.kumar@gmail.com")
                .build();*//*
        log.info("Author request started for postId:{}",postDto.getId());
         AuthorDto authorById = authorService.getAuthorById(postDto.getAuthorId());
        log.info("Author request completed for postId:{}",postDto.getId());
        return authorById;
    }*/
 public CompletableFuture<AuthorDto> getAuthor(PostDto postDto, DataFetchingEnvironment environment)  {

     //async call logic
     /*log.info("{} author request",environment.getExecutionId());

        log.info("Author main thread id : {}",Thread.currentThread().getId());
    return  CompletableFuture.supplyAsync(()->{
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("author thread id : {}",Thread.currentThread().getId());
        log.info("Author request started for postId:{}",postDto.getId());
        AuthorDto authorById = authorService.getAuthorById(postDto.getAuthorId());
        log.info("Author request completed for postId:{}",postDto.getId());
        return authorById;
    },executorService);*/

     //data loader
      DataLoader<UUID, AuthorDto> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.AUTHOR_DATA_LOADER);
        return dataLoader.load(postDto.getAuthorId());
 }

//without Completable future for sync call
 /*   public List<CommentDto> getComments(PostDto postDto, Integer first){
        *//*return Collections.singletonList(
                CommentDto.builder()
                        .id(UUID.randomUUID())
                        .authorId(UUID.randomUUID())
                        .build()
        );*//*
        log.info("comment request started for postId:{}",postDto.getId());
         List<CommentDto> firstFewCommentsByPostId = commentService.getFirstFewCommentsByPostId(postDto.getId(), first);
        log.info("comment request completed for postId:{}",postDto.getId());
        return firstFewCommentsByPostId;
    }*/
public CompletableFuture<List<CommentDto>> getComments(PostDto postDto, Integer first){
    log.info("Comment main thread id : {}",Thread.currentThread().getId());
    return CompletableFuture.supplyAsync(()->{
        log.info("comment thread id : {}",Thread.currentThread().getId());
        log.info("comment request started for postId:{}",postDto.getId());
        List<CommentDto> firstFewCommentsByPostId = commentService.getFirstFewCommentsByPostId(postDto.getId(), first);
        log.info("comment request completed for postId:{}",postDto.getId());
        return firstFewCommentsByPostId;
    },executorService);
}
}
