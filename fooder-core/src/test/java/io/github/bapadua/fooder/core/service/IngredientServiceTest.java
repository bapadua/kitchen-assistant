package io.github.bapadua.fooder.core.service;

import io.github.bapadua.fooder.core.entity.Ingredient;
import io.github.bapadua.fooder.core.repository.IngredientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceTest {

    @Mock
    IngredientRepository repository;
    @InjectMocks
    IngredientService service;

    @Test
    void context() {
        assertThat(repository).isNotNull();
        assertThat(service).isNotNull();
    }

    @Test
    @DisplayName("save valid ingredient")
    void shouldSaveAnValidObject() {
        UUID id = UUID.randomUUID();
        String name = "ingredient";
        String desc = "ingredient description";
        ArgumentCaptor<Ingredient> captor = ArgumentCaptor.forClass(Ingredient.class);

        service.save(new Ingredient(id, name, desc));

        verify(repository, times(1)).save(captor.capture());
        Ingredient result = captor.getValue();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).isEqualTo(desc);
    }

    @Test
    @DisplayName("search ingredient by name")
    void shouldSearchByIngredientName() {
        String expectedName = "ingredient_x";
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        service.findByName(expectedName);

        verify(repository, times(1)).findByName(captor.capture());
        String result = captor.getValue();
        assertThat(result).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("return ingredient list")
    void shouldReturnAllIngredients() {
        UUID id = UUID.randomUUID();
        String name = "ingredient_c";
        String description = "ingredient_desc";
        List<Ingredient> ingredients = List.of(new Ingredient(id, name, description));
        when(repository.findAll()).thenReturn(ingredients);

        List<Ingredient> result = service.find();

        verify(repository, times(1)).findAll();
        assertThat(result)
                .hasSameElementsAs(ingredients)
                .hasSameElementsAs(ingredients);

    }
}