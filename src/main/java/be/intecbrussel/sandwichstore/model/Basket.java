
package be.intecbrussel.sandwichstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;



    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Sandwich>sandwiches = new HashSet<>();


    public Basket() {
    }

    public Basket(String name) {
        this.name = name;
    }


    public Basket(String name, Set<Sandwich> sandwiches) {
        this.name = name;
        this.sandwiches = sandwiches;
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(Set<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;
        Basket basket = (Basket) o;
        return Objects.equals(getId(), basket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return name;
    }
}



