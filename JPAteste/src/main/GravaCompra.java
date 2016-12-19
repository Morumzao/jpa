package main;

import javax.persistence.*;

public class GravaCompra {

    public void grava(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("point");

        EntityManager manager = factory.createEntityManager();

        /*
        INSERE
        manager.getTransaction().begin();

        for(int i = 0; i < 100; i++) {
            manager.persist(new main.Point());
        }

        manager.getTransaction().commit();

        manager.close();

        */

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
        //BUSCA COM PARAM�TROS

        Query query = manager.createQuery(
                "SELECT p FROM main.Point AS p WHERE p.x > :paramX");
        query.setParameter("paramX", 30);

        List<main.Point> resultados = query.getResultList();

        for(main.Point p:resultados){
            System.out.printf("X: %d, Y: %d\n",p.getX(), p.getY());
        }
        */
    }

}
