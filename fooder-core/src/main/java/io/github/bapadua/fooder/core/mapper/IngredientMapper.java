package io.github.bapadua.fooder.core.mapper;


import io.github.bapadua.fooder.core.dto.IngredientDTO;
import io.github.bapadua.fooder.core.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "id", ignore = true)
    Ingredient toEntity (IngredientDTO dto);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "id", source = "id")
    IngredientDTO toDto(Ingredient ingredient);
}
