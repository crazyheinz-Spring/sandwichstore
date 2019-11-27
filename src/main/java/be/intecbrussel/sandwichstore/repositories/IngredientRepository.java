package be.intecbrussel.sandwichstore.repositories;

import be.intecbrussel.sandwichstore.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
