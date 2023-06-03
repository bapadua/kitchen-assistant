package io.github.bapadua.fooder.core.controller;

import io.github.bapadua.fooder.core.annotations.ValuesAllowed;
import io.github.bapadua.fooder.core.dto.IngredientDTO;
import io.github.bapadua.fooder.core.entity.Ingredient;
import io.github.bapadua.fooder.core.mapper.IngredientMapper;
import io.github.bapadua.fooder.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;
    private final IngredientMapper mapper;

    @PostMapping
    public ResponseEntity<IngredientDTO> register(@RequestBody IngredientDTO ingredient) {
        log.info("new ingredient request {}", ingredient);
        return ResponseEntity.ok(mapper.toDto(service.save(mapper.toEntity(ingredient))));
    }

    @GetMapping("/{ingredient}")
    public ResponseEntity<List<IngredientDTO>> findByName(@PathVariable("ingredient") String ingredient) {
        log.info("search for ingredient named: {}", ingredient);
        return ResponseEntity.ok(service.findByName(ingredient)
                .stream()
                .map(mapper::toDto)
                .toList());
    }
}
