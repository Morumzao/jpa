package test;

import junit.framework.TestCase;
import main.Compra;
import main.Pizza;
import main.Sabor;
import org.junit.Test;

/**
 * Created by Basis Tecnologia on 19/12/2016.
 */
public class CompraTest extends TestCase {

    @Test
    public void testAddPizza(){

        Compra compra = new Compra();
        Pizza pizza = new Pizza();
        Sabor sabor = new Sabor("Macarrão", 3);

        pizza.addSabor(sabor);

        double valorEsperado = 15;

        compra.addPizza(pizza);

        double valorEncontrado = compra.getPreco();

        assertEquals(valorEsperado, valorEncontrado, 0);

    }

}