import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI extends JFrame {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Board board = new Board();
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");

    JLabel count = new JLabel("0");
    JLabel countLabel = new JLabel("Count:");


    int spacing = 1;
    boolean Running = false;
    int numOfTurns = 0;
    int [][] grid = new int [64][50];

    public GUI(){

       start.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("starts program");
               Running = true;
           }
       });

       stop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("stops program");
            Running = false;
        }
    });

        panel.setLayout(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        panel.add(start);
        panel.add(stop);
        panel.add(countLabel);
        panel.add(count);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(board, BorderLayout.CENTER);
        frame.setSize(1286, 829);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1286, 1286);
        frame.setVisible(true);
        frame.setTitle("Langton's Ant");
        grid[31][24] = 2;

    }

    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.gray);
            g.fillRect(0,0,1286,1286);
            g.setColor(Color.white);
            for(int i = 0; i < 64; i++){
                for(int j = 0; j < 50; j++){
                    if(grid[i][j] == 0){
                        g.setColor(Color.white);
                    }
                    if(grid[i][j] == 1){
                        g.setColor(Color.black);
                    }
                    if(grid[i][j] == 2){
                        g.setColor(Color.red);
                    }
                    g.fillRect(i*15, j*15, 13, 13);
                }
            }

        }
    }

}  

