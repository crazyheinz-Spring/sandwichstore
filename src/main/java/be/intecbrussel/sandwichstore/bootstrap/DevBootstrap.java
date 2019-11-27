package be.intecbrussel.sandwichstore.bootstrap;

import be.intecbrussel.sandwichstore.repositories.*;
import be.intecbrussel.sandwichstore.model.*;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private IngredientRepository ingredientRepository;
    private SandwichRepository sandwichRepository;
    private BasketRepository basketRepository;
    private CustomerRepository customerRepository;


    public DevBootstrap(IngredientRepository ingredientRepository, SandwichRepository sandwichRepository, BasketRepository basketRepository, CustomerRepository customerRepository) {
        this.ingredientRepository = ingredientRepository;
        this.sandwichRepository = sandwichRepository;
        this.basketRepository = basketRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //initial ingredients (don't forget to save to repo before linking)

        Ingredient whiteBread = new Ingredient("white baguette", "bread", 1);
        Ingredient salad = new Ingredient("green iceberg salad", "vegetable", 1);
        Ingredient ketchup = new Ingredient("ketchup", "sauce", 1);
        Ingredient americain = new Ingredient("americain preparé", "meat", 1);
        Ingredient gouda = new Ingredient("young gouda", "cheese", 1);
        ingredientRepository.save(whiteBread);
        ingredientRepository.save(americain);
        ingredientRepository.save(salad);
        ingredientRepository.save(ketchup);
        ingredientRepository.save(gouda);


        //initial sandwiches
        Sandwich americainSandwich = new Sandwich("americain sandwich");
        Sandwich cheeseSandwich = new Sandwich("cheese sandwich");

        sandwichRepository.save(americainSandwich);
        sandwichRepository.save(cheeseSandwich);

        //initial basket
        Basket basket1 = new Basket("basket one");
        basketRepository.save(basket1);


        //initial customer

        Customer customer1 = new Customer("brecht");
        customerRepository.save(customer1);


        //adding ingredients to sandwich
        americainSandwich.addIngredient(americain);
        americainSandwich.addIngredient(whiteBread);

        sandwichRepository.save(americainSandwich);


        //adding ingredients to sandwich
        cheeseSandwich.addIngredient(gouda);

        sandwichRepository.save(cheeseSandwich);


        //adding sandwich to basket

        basket1.addSandwich(americainSandwich);
        basketRepository.save(basket1);


        //adding basket to client

        customer1.setBasket(basket1);
        customerRepository.save(customer1);
    }
}
