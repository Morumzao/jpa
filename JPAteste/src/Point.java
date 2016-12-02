import javax.persistence.*;

@Entity
@Table(name="point")
public class Point {

    @Id
    @GeneratedValue
    private long id;

    private static int _x = 0, _y = 100;

    private int x;
    private int y;

    public Point() {
        x = _x;
        y = _y;
        _x++;
        _y--;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
