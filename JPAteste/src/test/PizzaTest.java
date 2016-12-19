package test;
import main.Pizza;
import main.Sabor;

import junit.framework.*;

public class PizzaTest extends TestCase {

    public void testAddSabor(){

        Pizza pizza = new Pizza();
        double resultadoEsperado = 15.2;

        pizza.addSabor(new Sabor("Queijo", 3.2));

        double resultadoEncontrado = pizza.getPreco();

        assertEquals(resultadoEsperado,resultadoEncontrado,0);

    }

    public void testRemoveSabor(){

        Pizza pizza = new Pizza();
        double resultadoEsperado = 12;

        Sabor sabor = new Sabor("Queijo", 3.2);

        pizza.addSabor(sabor);
        pizza.removeSabor(sabor);

        double resultadoEncontrado = pizza.getPreco();

        assertEquals(resultadoEsperado,resultadoEncontrado,0);

    }

}
