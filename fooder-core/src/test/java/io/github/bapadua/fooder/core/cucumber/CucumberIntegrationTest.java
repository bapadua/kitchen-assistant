package io.github.bapadua.fooder.core.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bapadua.fooder.core.FooderCoreApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FooderCoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
public class CucumberIntegrationTest {
}
