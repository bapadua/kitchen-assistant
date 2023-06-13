package io.github.bapadua.fooder.core.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bapadua.fooder.core.FooderCoreApplication;
import io.github.bapadua.fooder.core.utils.IngredientHttpClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.http.HttpResponse;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@WebAppConfiguration
@ContextConfiguration(classes = FooderCoreApplication.class)
public class IntegrationTest<T> {

    @Autowired
    protected IngredientHttpClient client;

    protected HttpResponse<T> response;

    protected ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("http client load")
    public void context() {
        assertThat(client).isNotNull();
    }

    public <T> T convert(Map<String, String> map, Class<T> clazz) {
        return mapper.convertValue(map, clazz);
    }

}
