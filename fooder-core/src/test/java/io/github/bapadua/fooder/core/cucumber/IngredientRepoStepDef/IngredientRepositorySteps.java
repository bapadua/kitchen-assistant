package io.github.bapadua.fooder.core.cucumber.IngredientRepoStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bapadua.fooder.core.entity.Ingredient;
import io.github.bapadua.fooder.core.repository.IngredientRepository;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class IngredientRepositorySteps {

    @Autowired
    IngredientRepository repository;
    Ingredient ingredient;
    String name;

    @Given("the repository receive a valid ingredient")
    public void receiveIngredient() {
        ingredient = new Ingredient();
        ingredient.setName("Tapioca");
        ingredient.setDescription("Tapioca de mandioca");
    }

    @When("the ingredient should be persisted")
    public void persistIngredient() {
        ingredient = repository.save(ingredient);
    }

    @Then("the ingredient should be found on database")
    public void theIngredientShouldBeInDataBase() {
        Optional<Ingredient> result = repository.findById(ingredient.getId());
        Assertions.assertThat(result).isNotEmpty();
        ingredient = result.get();
        Assertions.assertThat(ingredient.getName()).isEqualTo("Tapioca");
    }

    @When("the user look up for the ingredient {string}")
    public void theUserLookUpForIngredient(String ingredientName) {
        Assertions.assertThat(ingredientName).isNotBlank();
        name = ingredientName;
    }

    @Then("the ingredient is found")
    public void theIngredientIsReturned() {
        Optional<Ingredient> result = repository.findByName(name);
        Assertions.assertThat(result).isNotEmpty();
        ingredient = result.get();
    }

    @Then("the ingredient is not found")
    public void theIngredientIsNotFound() {
        Optional<Ingredient> result = repository.findByName(name);
        Assertions.assertThat(result).isEmpty();
    }
}
