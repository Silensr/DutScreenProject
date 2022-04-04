import java.awt.event.*;
import javax.swing.Timer;
/**
 * Barre
 */


public class Main implements ActionListener{

    private Barre jauge;
    private Timer tick;

    public Main()
    {
        jauge = new Barre(true);

        tick = new Timer(1000, this);

        tick.start();
    }
    public static void main(String[] args) {
        
        new Main();

    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == tick) {
            jauge.setLevel((int) (Math.random()*1023));

            jauge.repaint();
        }
    }   
}