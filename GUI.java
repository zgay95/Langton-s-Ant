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

    public GUI(){

       start.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("starts program");

           }
       });

       stop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("stops program");

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
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setTitle("Langton's Ant");


        
        

    }

    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0,0,1280,800);
            g.setColor(Color.gray);
            for(int i = 0; i < 11; i++){
                for(int j = 0; j<11; j++){
                    g.fillRect(spacing+i*30, spacing+j*30+30, 30-2*spacing, 30-2*spacing);
                }
            }

        }
    }

}  

