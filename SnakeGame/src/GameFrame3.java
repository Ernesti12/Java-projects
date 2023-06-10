import javax.swing.JFrame;

public class GameFrame3 extends JFrame{

    GameFrame3(){

        this.add(new GamePanel3());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
