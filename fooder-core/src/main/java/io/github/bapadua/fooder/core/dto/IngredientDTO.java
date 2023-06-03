package io.github.bapadua.fooder.core.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record IngredientDTO(
        UUID id,
        @JsonProperty("name")
        String name,
        @JsonProperty("description")
        String description
) {
    public IngredientDTO(UUID id, String name, String description) {
        this.id =id;
        this.name = name;
        this.description = description;
    }
}
