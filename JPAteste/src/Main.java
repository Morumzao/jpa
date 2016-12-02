import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("point");

        EntityManager manager = factory.createEntityManager();

        /*
        INSERE
        manager.getTransaction().begin();

        for(int i = 0; i < 100; i++) {
            manager.persist(new Point());
        }

        manager.getTransaction().commit();

        manager.close();

        */

        /*
        BUSCA E MOSTRA
        Point[] area = new Point[20];

        for(int i = 0; i < area.length; i++){
            area[i] = manager.find(Point.class, (long)i+202L);
        }

        for(int i = 0; i < area.length; i++){
            System.out.printf("X: %d, Y: %d\n",area[i].getX(), area[i].getY());
        }
        */

        /*
        //BUSCA COM PARAMÊTROS

        Query query = manager.createQuery(
                "SELECT p FROM Point AS p WHERE p.x > :paramX");
        query.setParameter("paramX", 30);

        List<Point> resultados = query.getResultList();

        for(Point p:resultados){
            System.out.printf("X: %d, Y: %d\n",p.getX(), p.getY());
        }
        */

    }

}