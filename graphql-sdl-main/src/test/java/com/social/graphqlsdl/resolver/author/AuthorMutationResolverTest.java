package com.social.graphqlsdl.resolver.author;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.social.graphqlsdl.TestApplication;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
class AuthorMutationResolverTest {
    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;
    @Test
    public void shouldAbleToCreateAuthorData() throws IOException, JSONException {
        GraphQLResponse graphQLResponse=graphQLTestTemplate.postForResource("request/author-mutation.graphqls");
        String uuid=graphQLResponse.get("$.data.createAuthor");
        MatcherAssert.assertThat(uuid,is(Matchers.notNullValue()));


    }
}