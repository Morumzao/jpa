package test;

import junit.framework.*;

public class AllTest {

    public static Test suite(){

        TestSuite suite = new TestSuite("Teste da aplica��o.");

        suite.addTestSuite(PizzaTest.class);
        suite.addTestSuite(CompraTest.class);

        return suite;

    }

}