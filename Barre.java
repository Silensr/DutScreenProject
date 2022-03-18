import javax.swing.*;
import java.awt.*;
import java.awt.Color;
/**
 * InnerBarre
 */
public class Barre extends JFrame{

    private int height, width, level = 512;


    public Barre(){
        this.height = 100;
        this.width = 500;

        this.setTitle("Noise level");
        
        this.setSize(width, height);

        

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.paint(this.getGraphics());
    }

    public Barre(int height, int width){
        this.height = height;
        this.width = width;

        this.setTitle("Noise level");
        
        this.setSize(width, height);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static Color colorMixer(int level, int max) {
        
        float x = ((float) level)/((float) max);
        
        

        return new Color(1-x,(float)0,x);
    }

    public void paint(Graphics g){
        super.paint(g);
        
        double quantum =   ((double) width)/1023.0;

        g.setColor(Color.BLACK);

        g.drawRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = 0; i < (int) level*quantum; i++) {
            
            

            g.setColor(colorMixer(i, this.getWidth()));

            g.drawLine(i, 1, i, this.getHeight()-1);
        }

    }

}
