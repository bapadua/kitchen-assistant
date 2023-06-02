package io.github.bapadua.fooder.core.cucumber;

import io.github.bapadua.fooder.core.FooderCoreApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;


@WebAppConfiguration
@ContextConfiguration(classes = FooderCoreApplication.class)
public class IntegrationTest {

    @Autowired
    protected WebTestClient client;

}
