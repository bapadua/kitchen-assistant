package io.github.bapadua.fooder.core.cucumber.version;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bapadua.fooder.core.cucumber.IntegrationTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionStepDef extends IntegrationTest<String> {

    @When("the client calls the version endpoint")
    public void theClientMakeAEndPointRequest() throws Exception {
        response = client.get("/version");
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int status) {
        assertThat(response.statusCode()).isEqualTo(status);
    }

    @And("the client receives server version {string}")
    public void theClientReceivesServerVersion(String version) {
        assertThat(response.body()).isEqualTo(version);
    }
}
