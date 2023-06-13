package io.github.bapadua.fooder.core.cucumber.ingredient;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bapadua.fooder.core.cucumber.IntegrationTest;
import io.github.bapadua.fooder.core.dto.IngredientDTO;
import io.github.bapadua.fooder.core.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class IngredientsStepDef extends IntegrationTest<String> {

    @DataTableType
    @SuppressWarnings("unused")
    public IngredientDTO transform(Map<String, String> map) {
        return new IngredientDTO(null, map.get("name"), map.get("description"));
    }
    List<IngredientDTO> ingredients;

    IngredientDTO dto;

    @Given("the user tries to save the following ingredient")
    public void receiveIngredient(List<IngredientDTO> items) {
        ingredients = items;
        Assertions.assertThat(items).isNotNull();
        dto = items.get(0);
    }

    @When("^the user calls \\/ingredient post$")
    public void theUserCallsIngredientPost() throws IOException, URISyntaxException, InterruptedException {
        response = client.post("/ingredient", dto);

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Then("the ingredient is returned")
    public void theIngredientIsReturned(IngredientDTO ingredient) throws JsonProcessingException {
        IngredientDTO response = ObjectUtils.convert(this.response.body(), IngredientDTO.class);
        assertThat(response).isNotNull();
        assertThat(response.id()).isInstanceOf(UUID.class);
        assertThat(response.name()).isEqualTo(ingredient.name());
        assertThat(response.description()).isEqualTo(ingredient.description());
    }

    @When("the user calls \\/ingredient get with path {string}")
    public void theUserLookUpForIngredient(String ingredientName) {
    }

    @Then("the ingredient is not found")
    public void theIngredientIsNotFound() {
    }
}
