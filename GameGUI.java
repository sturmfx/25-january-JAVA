import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GameGUI extends JPanel implements ActionListener
{
    Random r;
    Timer t;
    Color background = Color.BLACK;
    int delay = 200;
    int width = 500;
    int height = 500;

    double radius = 100;
    Color c_color = Color.RED;

    ArrayList<Circle> circles = new ArrayList<Circle>();

    ArrayList<Color> colors = new ArrayList<Color>();

    int max_radius = 100;
    int min_radius = 50;

    public GameGUI()
    {
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);

        r = new Random();
        t = new Timer(delay, this);
        addMouseListener(new GameMouseAdaptor());
        addKeyListener(new GameKeyboardAdaptor());
        setBackground(background);
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        t.start();
    }

    public static void main(String args[])
    {
        GameGUI game = new GameGUI();
        GameWindow gw = new GameWindow("GAME");
        gw.add(game);
        gw.pack();
        gw.setVisible(true);
    }


    public void tick()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        tick();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Circle c: circles)
        {
            g.setColor(c.color);
            g.fillOval((int)c.x - (int)c.radius, (int)c.y - (int)c.radius, (int)c.radius * 2, (int)c.radius * 2);
        }
    }

    private class GameMouseAdaptor extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent m)
        {
            double x = m.getX();
            double y = m.getY();
            Color color1 = colors.get(r.nextInt(colors.size()));
            double radius1 = min_radius + r.nextInt(max_radius - min_radius);
            Circle c = new Circle(x, y, radius1, color1);
            circles.add(c);
        }
    }

    private class GameKeyboardAdaptor extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent k)
        {

        }
    }
}