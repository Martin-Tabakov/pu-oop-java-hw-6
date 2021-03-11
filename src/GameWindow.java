import Board.*;
import Containers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;


public class GameWindow extends JFrame implements MouseListener {

    Timer t = new Timer();
    Board b;
    Snake s;
    Obstacles o;
    Foods f;

    public GameWindow() {
        b = new Board(0,30,50,50);
        s = new Snake();
        o = new Obstacles();
        f = new Foods();


        s.add(b.getTile(20, 20), new Node(20,20, DType.body));

        Tile tile =b.getRandomEmptyTile();
        System.out.println(tile.getX());
        System.out.println(tile.getY());
        f.add(tile,new Node(tile.getX(),tile.getY(),DType.food));

        tile = b.getRandomEmptyTile();
        o.add(tile,new Node(tile.getX(),tile.getY(),DType.obstacle));


        this.setSize(500, 530);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);
        this.setVisible(true);
    }

TimerTask timerTask = new TimerTask() {
    @Override
    public void run() {
        makeMove();
    }


};

    public void loop() {
            t.schedule(timerTask, 0,500);

    }


    private void makeMove() {
        System.out.println("Tick!");
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        b.draw(g);
        s.draw(g);
        f.draw(g);
        o.draw(g);
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click!");

        s.setDestination(b.getTile(22,20));

        /*timerTask.cancel();
        t.cancel();
        t.purge();*/
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
