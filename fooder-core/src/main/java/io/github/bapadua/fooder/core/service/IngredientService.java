package io.github.bapadua.fooder.core.service;

import io.github.bapadua.fooder.core.entity.Ingredient;
import io.github.bapadua.fooder.core.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository repository;

    public List<Ingredient> find() {
        return repository.findAll();
    }

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public List<Ingredient> findByName(final String name) {
        return repository.findByName(name);
    }
}
