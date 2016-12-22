package main;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private long id;

    @Transient
    private List<Pizza> pizzas = new ArrayList<Pizza>();

    private double preco = 0;

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
        preco += pizza.getPreco();
    }

    public void removePizza(Pizza pizza){
        pizzas.remove(pizza);
        preco -= pizza.getPreco();
    }

    //SET & GET
    public List<Pizza> getPizzas(){
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas){
        this.pizzas = pizzas;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public long getId(){
        return id;
    }

}