import javax.swing.*;

public class SnakeGame {

    public static void main(String[] args) {


        String ch = JOptionPane.showInputDialog(null,"Select a difficulty: \n"
                + "1. Easy \n" + "2. Hard \n" + "3. Very Hard",
                "Snake Game",JOptionPane.INFORMATION_MESSAGE);
          int choice = Integer.parseInt(ch);

        if(choice == 1){
            new GameFrame();
        }else if(choice == 2){
            new GameFrame2();
        }else if(choice == 3){
            new GameFrame3();
        }
    }
}