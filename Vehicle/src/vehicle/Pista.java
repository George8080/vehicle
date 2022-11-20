

package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author jorge
 */
public class Pista {
    public Pista(){
    }
    
    public void paint(Graphics g){
        Graphics2D road = (Graphics2D)g;
        road.setColor(Color.gray);
        road.fillOval(30, 30, 600, 600);     
    }
}
