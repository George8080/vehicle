
package CarCreation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.*;

/**
 *
 * @author Daniela Novoa
 * @author Jorge Santis
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
    
    /**
     * 
     * @param c Este párametro recibe el color del auto desde la clase PanelPrincipal
     * @param x 
     * @param y 
     */

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
     
        
        intX = new int[]{0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            intX[i] = (int) (x + radio[i]*cos(Math.toRadians(degrees[i])));
        }
        intY = new int[]{0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            intY[i] = (int) (y + radio[i]*sin(Math.toRadians(degrees[i])));
        }
    }
    /**
     *  Con este método creamos el moviemiento del auto y las ruedas
     * 
     * @param vel Este parametro recibe la velocidad con la que avanza
     *  o retrocede el auto
     * @param angle Este parametro recibe el ángulo de rotación del 
     *  auto y las ruedas, por ejemplo si el angulo es cero significa que
     *  esta avanzando en dirección recta
     */
    public void setXY(double vel, double angle){
        degree += vel*angle/3;
        centerY =  (centerY + 3*vel*sin(Math.toRadians(degree)));
        centerX =  (centerX + 3*vel*cos(Math.toRadians(degree)));

        for(int i = 0; i < 5; i++){
            intX[i] = (int) (centerX + radio[i]*cos(Math.toRadians(degrees[i]+degree)));
        }
        for(int i = 0; i < 5; i++){
            intY[i] = (int) (centerY + radio[i]*sin(Math.toRadians(degrees[i]+degree)));
        }
        lowerLeft.setXY(centerX, centerY,angle*vel/3,0);
        lowerRight.setXY(centerX, centerY,angle*vel/3,0);
        upperLeft.setXY(centerX, centerY, angle*vel/3,8*angle);
        upperRight.setXY(centerX,centerY, angle*vel/3,8*angle);
    }
    public double getCenterX(){
        return centerX;
    }
    public double getCenterY(){
            return centerY;
    }
    
    /**
     * 
     * @param g 
     */
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
