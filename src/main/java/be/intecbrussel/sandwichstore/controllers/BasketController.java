
package be.intecbrussel.sandwichstore.controllers;

import be.intecbrussel.sandwichstore.model.Basket;
import be.intecbrussel.sandwichstore.repositories.BasketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasketController {

    private BasketRepository basketRepository;

    public BasketController(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    @GetMapping("/basket")
    public String getOrders(Model model){

        model.addAttribute("newOrder", new Basket());
        model.addAttribute("orderRepo", basketRepository.findAll());

        return "basket";
    }


    @PostMapping("/basket")
    public String addSandwich(@ModelAttribute Basket basket, Model model) {


        model.addAttribute("newOrder", basketRepository.save(basket));
        model.addAttribute("orderRepo", basketRepository.findAll());

        return "basketAdded";

    }



}



