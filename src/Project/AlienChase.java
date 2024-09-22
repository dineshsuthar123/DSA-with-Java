package Project;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class AlienChase extends JPanel {
    
    private int X = 50; 
    private int Y = 50; 
    private final int Size = 50;

    public AlienChase() {
        
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                
                X = e.getX() - Size / 2;
                Y = e.getY() - Size / 2;
                repaint(); 
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN); 
        g.fillOval(X, Y, Size, Size); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alien Chase");
        AlienChase alienChase = new AlienChase();
        frame.add(alienChase);
        frame.setSize(800, 600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

