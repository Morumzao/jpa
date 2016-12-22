package main;

import javax.persistence.*;
import java.util.List;

public final class GravaCompra {

    private GravaCompra(){}

    private static EntityManagerFactory factory;

    private static EntityManager manager;

    private static void init(){
        factory = Persistence.createEntityManagerFactory("compra");
        manager = factory.createEntityManager();
    }

    public static void gravarCompra(Compra compra){

        init();

        manager.getTransaction().begin();

        manager.persist(compra);

        Object[] pizzas = compra.getPizzas().toArray();

        for(int i = 0; i < pizzas.length; i++){
            ((Pizza) pizzas[i]).setCompraId(compra.getId());
            manager.persist(pizzas[i]);
        }

        manager.getTransaction().commit();

        manager.close();

    }

    public static List<Compra> getCompras(){

        init();

        Query query = manager.createQuery("SELECT c FROM Compra AS c");

        return (List<Compra>) query.getResultList();

    }

        /*
        BUSCA E MOSTRA
        main.Point[] area = new main.Point[20];

        for(int i = 0; i < area.length; i++){
            area[i] = manager.find(main.Point.class, (long)i+202L);
        }

        for(int i = 0; i < area.length; i++){
            System.out.printf("X: %d, Y: %d\n",area[i].getX(), area[i].getY());
        }
        */

        /*
        //BUSCA COM PARAMÊTROS

        Query query = manager.createQuery(
                "SELECT p FROM main.Point AS p WHERE p.x > :paramX");
        query.setParameter("paramX", 30);

        List<main.Point> resultados = query.getResultList();

        for(main.Point p:resultados){
            System.out.printf("X: %d, Y: %d\n",p.getX(), p.getY());
        }
        */

}
