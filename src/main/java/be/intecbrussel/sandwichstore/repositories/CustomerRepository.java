package be.intecbrussel.sandwichstore.repositories;

import be.intecbrussel.sandwichstore.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
