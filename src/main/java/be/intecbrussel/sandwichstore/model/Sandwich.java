package be.intecbrussel.sandwichstore.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER) //inform!
    private Set<Ingredient> ingredients = new HashSet<>();


    public Sandwich() {
    }

    public Sandwich(String name) {
        this.name = name;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sandwich)) return false;
        Sandwich sandwich = (Sandwich) o;
        return Objects.equals(getId(), sandwich.getId());
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

