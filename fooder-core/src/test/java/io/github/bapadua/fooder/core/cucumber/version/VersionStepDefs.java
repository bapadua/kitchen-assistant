package io.github.bapadua.fooder.core.cucumber.version;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bapadua.fooder.core.cucumber.IntegrationTest;
import org.springframework.test.web.reactive.server.WebTestClient;

public class VersionStepDefs extends IntegrationTest {

    WebTestClient.ResponseSpec response;

    @When("^the client calls /version$")
    public void theClientMakeAEndPointRequest() {
        response = client.get()
                .uri("/version")
                .exchange();
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int status) {
        response.expectStatus()
                .isEqualTo(status);
    }

    @And("the client receives server version {string}")
    public void theClientReceivesServerVersion(String version) {
        response.expectBody()
                .consumeWith(System.out::println);
    }
}
