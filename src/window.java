import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class window extends JPanel implements Runnable {
    boolean p37 = false;
    boolean p39 = false;
    Ball b = new Ball();
    Pad p = new Pad();
    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case 37:
                    if (p37 == false){
                        p.vx += -2;
                        p37 = true;
                    }
                    break;
                case 39:
                    if (p39 == false){
                        p.vx += 2;
                        p39 = true;
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case 37:
                    p.vx += 2;
                    p37 = false;
                    break;
                case 39:
                    p.vx += -2;
                    p39 = false;
                    break;
                case 32:
                    b.startItUP();
                    break;
            }
        }
    };
    ActionListener a = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("updatecycle");
            System.out.println(b.x);
            b.ballupdater();
            p.padupdater();
            if (GOcheck()){
                JOptionPane.showMessageDialog(getParent(), "You ded", "You SO ded!", JOptionPane.YES_NO_OPTION);
                System.exit(ABORT);
            }
            getParent().repaint();
        }
    };

    @Override
    public void run() {
        b.setCords(getWidth(),getHeight());
        p.setStart(getWidth(),getHeight());
        Timer t = new Timer(7, a);
        t.start();
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillOval(b.x, b.y, 15, 15);
        g.fillRoundRect(p.x, p.y, 86, 15, 15, 15);
    }

    public boolean GOcheck(){
        if (b.y > p.y-15){
            if ((b.x>p.x-10) && (b.x<p.x+20)){
                b.vx -= 1;
                b.dvy();
                return false;
            }
            else if((b.x>p.x+21) && (b.x<p.x+65)){
                b.dvy();
                return false;
            }
            else if ((b.x>p.x+66) && (b.x<p.x+95)){
                b.vx += 1;
                b.dvy();
                return false;
            }
            return true;
        }
        return false;
    }
}