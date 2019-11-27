package be.intecbrussel.sandwichstore.controllers;

import be.intecbrussel.sandwichstore.model.Sandwich;
import be.intecbrussel.sandwichstore.repositories.SandwichRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SandwichController {

    private SandwichRepository sandwichRepository;

    public SandwichController(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    @GetMapping("/sandwiches")
    public String getSandwiches(Model model){

        model.addAttribute("newSandwich", new Sandwich());
        model.addAttribute("sandwichRepo", sandwichRepository.findAll());

        return "sandwiches";
    }

    @PostMapping("/sandwiches")
    public String addSandwich(@ModelAttribute Sandwich sandwich, Model model) {


        model.addAttribute("newSandwich", sandwichRepository.save(sandwich));
        model.addAttribute("sandwichRepo", sandwichRepository.findAll());

        return "sandwichesAdded";

    }
}
