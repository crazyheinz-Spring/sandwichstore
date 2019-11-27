package be.intecbrussel.sandwichstore.controllers;
import be.intecbrussel.sandwichstore.model.Ingredient;
import be.intecbrussel.sandwichstore.repositories.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    private IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public String getIngredients(Model model){

        model.addAttribute("newIngredient", new Ingredient());
        model.addAttribute("ingredientRepo", ingredientRepository.findAll());

        return "ingredients";
    }

    @PostMapping("/ingredients")
    public String addIngredients(@ModelAttribute Ingredient ingredient, Model model) {


        model.addAttribute("newIngredient", ingredientRepository.save(ingredient));
        model.addAttribute("ingredientRepo", ingredientRepository.findAll());

        return "ingredientsAdded";

    }

}
