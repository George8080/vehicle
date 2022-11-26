
package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author danino y jorge
 */
public class Ruedas{
    private int centerX;
    private int centerY;
    private int centerRadio;
    private int[] intX;
    private int[] intY;
    private double[] radio;
    private double degree=0;
    private double[] degrees;
    private double angulo;
    
    public Ruedas ( int cX, int x, int cY, int y, double angle) {
        angulo = Math.toDegrees(Math.atan(y/x))+angle;
        System.out.println(angulo);
        centerX = (int) (cX+ Math.sqrt(x*x + y*y)*sin(Math.toRadians(angulo)));
        centerY = (int) (cY+ Math.sqrt(x*x + y*y)*sin(Math.toRadians(angulo)));
        //centerRadio = (int) Math.sqrt(x*x+y*y);
        radio = new double[]{Math.sqrt(41),Math.sqrt(41),Math.sqrt(41),Math.sqrt(41)};
        degrees = new double[]{30+angle,-30+angle,-150+angle,150+angle};
        /*intX = new int[]{x+40, x+20, x-30, x-30, x+20};
        intY = new int[]{y, y+25, y+15, y-15, y-25};*/
        
        intX = new int[]{0,0,0,0};
        for(int i = 0; i < 4; i++){
            intX[i] = (int) (centerX + radio[i]*cos(Math.toRadians(degrees[i])));
        }
        intY = new int[]{0,0,0,0};
        for(int i = 0; i < 4; i++){
            intY[i] = (int) (centerY + radio[i]*sin(Math.toRadians(degrees[i])));
    }
    
    }
    public void setXY(int vel, double angle){
        angulo += angle;
        centerY = (int) (centerY + vel*sin(Math.toRadians(angulo)));
        centerX = (int) (centerX + vel*cos(Math.toRadians(angulo)));
        
        for(int i = 0; i < 4; i++){
            intX[i] = (int) (centerX + radio[i]*cos(Math.toRadians(degrees[i]+angulo)));
        }
        for(int i = 0; i < 4; i++){
            intY[i] = (int) (centerY + radio[i]*sin(Math.toRadians(degrees[i]+angulo)));
        }
    
    }
 
    
    public void paint(Graphics g){
    Graphics2D tire = (Graphics2D)g;
        tire.setColor(Color.black);           //upper left tire
        tire.fillPolygon(intX, intY, 4);
    
    }
    
}
