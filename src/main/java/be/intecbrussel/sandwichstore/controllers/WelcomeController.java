package be.intecbrussel.sandwichstore.controllers;
import be.intecbrussel.sandwichstore.model.Customer;
import be.intecbrussel.sandwichstore.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {

    private CustomerRepository customerRepository;

    public WelcomeController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/welcome")
    public String getCustomer(Model model){

        model.addAttribute("newCustomer", new Customer());


        return "welcome";
    }

    @PostMapping("/welcome")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {


        model.addAttribute("newCustomer", customerRepository.save(customer));


        return "homePage";

    }

}
