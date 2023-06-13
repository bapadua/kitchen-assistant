package io.github.bapadua.fooder.core.mapper;

import io.github.bapadua.fooder.core.dto.IngredientDTO;
import io.github.bapadua.fooder.core.entity.Ingredient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class IngredientMapperTest {
    IngredientMapper mapper = IngredientMapper.INSTANCE;

    @Test
    @DisplayName("load mapper")
    void context() {
        assertThat(mapper).isNotNull();
    }

    @Test
    @DisplayName("map to ingredient entity")
    void mapToEntity() {
        String expectedName = "Massa Panquecas";
        String expectedDescription = "Massa australiana";
        IngredientDTO dto = new IngredientDTO(null, expectedName, expectedDescription);

        Ingredient entity = mapper.toEntity(dto);

        assertThat(entity.getName()).isEqualTo(expectedName);
        assertThat(entity.getDescription()).isEqualTo(expectedDescription);
    }

    @Test
    @DisplayName("map to ingredient dto")
    void mapToDto() {
        String expectedName = "Massa Panquecas";
        String expectedDescription = "Massa australiana";
        Ingredient ingredient = new Ingredient(UUID.randomUUID(), expectedName, expectedDescription);

        IngredientDTO dto = mapper.toDto(ingredient);

        assertThat(dto.name()).isEqualTo(expectedName);
        assertThat(dto.description()).isEqualTo(expectedDescription);
    }
}