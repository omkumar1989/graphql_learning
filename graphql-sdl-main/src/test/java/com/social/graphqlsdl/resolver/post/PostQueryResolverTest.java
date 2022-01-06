package com.social.graphqlsdl.resolver.post;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.social.graphqlsdl.TestApplication;
import org.hamcrest.MatcherAssert;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
class PostQueryResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;
    @Test
    public void shouldAbleToGetPostData() throws IOException, JSONException {
        GraphQLResponse graphQLResponse=graphQLTestTemplate.postForResource("request/recent-post-query.graphqls");
        MatcherAssert.assertThat(graphQLResponse.isOk(), equalTo(true));
        //assertEquals(FileReaderUtil.read("response/recent-post-query.json"),graphQLResponse.getRawResponse().getBody(),true);

    }

}