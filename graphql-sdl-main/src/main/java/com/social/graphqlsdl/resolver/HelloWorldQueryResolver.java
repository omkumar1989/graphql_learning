package com.social.graphqlsdl.resolver;


import com.social.graphqlsdl.dto.CustomerDto;
import com.social.graphqlsdl.dto.MessageDto;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {
    public String getHelloWorld(){
        return "Hello World ! Graphql is nice";
    }

    public String greetingMessage(String fname,String lname){
        return String.format("Hello %s %s ",fname,lname);
    }
    public MessageDto getMessage(){

        return  MessageDto.builder()
                .id(UUID.randomUUID())
                .text("Graphql is awesome")
                .build();
    }
    public List<Integer> getRolDice(){
        return Arrays.asList(1,2,3,4);
    }

    public CustomerDto customer(){
            return CustomerDto.builder()
                    .birthDay(LocalDate.now())
                    .workStartTime(OffsetTime.now())
                    .bornAt(OffsetDateTime.now())
                    .build();
    }
    public CustomerDto customerDetail(String phoneNumber, String email){
        return CustomerDto.builder()
                .birthDay(LocalDate.now())
                .workStartTime(OffsetTime.now())
                .bornAt(OffsetDateTime.now())
                .profileLink("Some link")
                .build();
    }
}
