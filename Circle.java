import java.awt.*;

public class Circle
{
    double x;
    double y;
    double radius;
    Color color;

    double speed = 30;
    double dx = 0;
    double dy = 0;

    int target_x = 250;
    int target_y = 250;
    public Circle(double x1, double y1, double r, Color c)
    {
        this.x = x1;
        this.y = y1;
        this.radius = r;
        this.color = c;
    }

    public void update(int tx, int ty)
    {
        dx = tx - x;
        dy = ty - y;
        double dist = Math.sqrt(dx * dx + dy * dy);
        dx = dx * speed/dist;
        dy = dy * speed/dist;
        target_x = tx;
        target_y = ty;
    }
}
