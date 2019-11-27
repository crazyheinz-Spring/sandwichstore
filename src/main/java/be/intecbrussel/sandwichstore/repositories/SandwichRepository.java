package be.intecbrussel.sandwichstore.repositories;


import be.intecbrussel.sandwichstore.model.Sandwich;
import org.springframework.data.repository.CrudRepository;

public interface SandwichRepository extends CrudRepository<Sandwich, Long> {
}
