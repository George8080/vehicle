
package CarCreation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.*;

/**
 *
 * @author jorge y danino
 */
public class Auto {
    private Color color;
    private double centerX;
    private double centerY;
    private int[] intX;
    private int[] intY;
    private Ruedas  upperLeft;
    private Ruedas upperRight;
    private Ruedas lowerLeft;
    private Ruedas lowerRight;
    private double[] radio;
    private double degree = 0;
    private double[] degrees;

    public Auto (Color c, int x, int y){
        color = c;
        centerX = x;
        centerY = y;
        radio = new double[]{40,Math.sqrt(400+625),Math.sqrt(90+225),Math.sqrt(90+225),Math.sqrt(400+625)};
        degrees = new double[]{0,-40,-140,140,40};
        lowerLeft= new Ruedas(x,-12,y,12,degree);
        lowerRight= new Ruedas(x,-12,y,-12,degree);
        upperLeft= new Ruedas(x,15,y,20,degree);
        upperRight= new Ruedas(x,15,y,-20,degree);
        
        
        /*intX = new int[]{x+40, x+20, x-30, x-30, x+20};
        intY = new int[]{y, y+25, y+15, y-15, y-25};*/
        
        intX = new int[]{0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            intX[i] = (int) (x + radio[i]*cos(Math.toRadians(degrees[i])));
        }
        intY = new int[]{0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            intY[i] = (int) (y + radio[i]*sin(Math.toRadians(degrees[i])));
        }
    }
    
    public void setXY(double vel, double angle){
        //if(vel!=0){
        degree += vel*angle/3;
        centerY =  (centerY + 3*vel*sin(Math.toRadians(degree)));
        centerX =  (centerX + 3*vel*cos(Math.toRadians(degree)));


        for(int i = 0; i < 5; i++){
            intX[i] = (int) (centerX + radio[i]*cos(Math.toRadians(degrees[i]+degree)));
        }
        for(int i = 0; i < 5; i++){
            intY[i] = (int) (centerY + radio[i]*sin(Math.toRadians(degrees[i]+degree)));
        }
        //}
        /*for(int i = 0; i < 5; i++){
            //if(angle!=0) intY[i]+=(int)((intY[i]-centerY)*sin(Math.toRadians(degree)));
            intY[i]+=(int)(vel*sin(Math.toRadians(degree)));
        }
        for(int i = 0; i < 5; i++){
            //if(angle!=0) intX[i]+=(int)((intX[i]-centerX)*cos(Math.toRadians(degree)));
            intX[i]+=(int)(cos(Math.toRadians(degree))*vel);
        }*/
        lowerLeft.setXY(centerX, centerY,angle*vel/3,0);
        lowerRight.setXY(centerX, centerY,angle*vel/3,0);
        upperLeft.setXY(centerX, centerY, angle*vel/3,8*angle);
        upperRight.setXY(centerX,centerY, angle*vel/3,8*angle);
    }
    
    public void paint(Graphics g){
        Graphics2D car = (Graphics2D)g;
        lowerLeft.paint(g);
        lowerRight.paint(g);
        upperLeft.paint(g);
        upperRight.paint(g);
        car.setColor(color);
        car.fillPolygon(intX, intY, 5);
        
    }
}
