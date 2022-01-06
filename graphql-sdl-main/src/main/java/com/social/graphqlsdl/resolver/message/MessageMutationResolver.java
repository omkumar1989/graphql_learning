package com.social.graphqlsdl.resolver.message;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageMutationResolver implements GraphQLMutationResolver {


    public UUID createMessage(UUID id,String title, Integer[] luckyNumber,Integer value){


        return UUID.randomUUID();
    }
}
