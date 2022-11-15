
package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author jorge
 */
public class Auto {
    private Color color;
    private int[] intX;
    private int[] intY;
    public Auto (Color c){
        color = c;
        intX = new int[]{80, 140, 150, 110, 70};
        intY = new int[]{300, 300, 220, 180, 220};
    }
    
    public void setXY(int x, int y, int angle){
        
    }
    
    public void paint(Graphics g){
        Graphics2D car = (Graphics2D)g;
        car.setColor(color);
        car.fillPolygon(intX, intY, 5);
    }
}
