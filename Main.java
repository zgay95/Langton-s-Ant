import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

public class Main implements Runnable {

    GUI gui = new GUI();

    public static void main(String[] args) {
        new Thread(new Main()).start();

    }

    @Override
    public void run() {
        Ant ant = new Ant();
        Graphics2D g2d = (Graphics2D) gui.board.getGraphics();

        while (true) {
            gui.repaint();

            while (gui.Running == true) {
                gui.board.paintComponent(g2d);
                // System.out.println("Ant X:" + ant.LocX);
                // System.out.println("Ant Y:" + ant.LocY);
                // System.out.println("\n");
                if (ant.LocX + 1 > 63 || ant.LocY + 1 > 49 || ant.LocX - 1 < 0 || ant.LocY - 1 < 0) {
                    System.out.println("offgrid");
                    gui.Running = false;
                    break;
                }
                ant.setLocation(gui.grid, ant.LocX, ant.LocY);

                gui.numOfTurns++;
                gui.count.setText(Integer.toString(gui.numOfTurns));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
