
package be.intecbrussel.sandwichstore.repositories;


import be.intecbrussel.sandwichstore.model.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {
}


