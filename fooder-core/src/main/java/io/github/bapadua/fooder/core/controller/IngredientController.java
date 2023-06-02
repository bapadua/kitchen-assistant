package io.github.bapadua.fooder.core.controller;

import io.github.bapadua.fooder.core.annotations.ValuesAllowed;
import io.github.bapadua.fooder.core.dto.IngredientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @PostMapping
    public Mono<ResponseEntity<IngredientDTO>> register(@RequestBody IngredientDTO ingredient) {
        return Mono.just(ResponseEntity.ok(ingredient));
    }

    @GetMapping
    public ResponseEntity<Flux<IngredientDTO>> find(@ValuesAllowed(propName = "orderBy", values = {"name", "description"}) @RequestParam("orderBy") String orderBy) {
        return ResponseEntity.ok(Flux.just(new IngredientDTO("teste", "description")));
    }
}
