import javax.swing.*;

public class Paranoid{

    public static void main(String[] args){
        JFrame frame = new JFrame();
        window game = new window();
        frame.setSize(800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(game);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.addKeyListener(game.kl);
        game.run();



    }
}
