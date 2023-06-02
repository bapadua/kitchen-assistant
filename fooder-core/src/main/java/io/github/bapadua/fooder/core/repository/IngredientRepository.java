package io.github.bapadua.fooder.core.repository;

import io.github.bapadua.fooder.core.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
    @Query("SELECT i FROM Ingredient i WHERE i.name = :name")
    Optional<Ingredient> findByName(@Param("name") String name);
}
