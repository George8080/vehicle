
package CarCreation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author Daniela Novoa
 * @author Jorge Santis
 */
public class Ruedas{
    private double wheelRad;
    private double wheelAng;
    private int[] intX = new int[]{0,0,0,0};
    private int[] intY = new int[]{0,0,0,0};
    private double radio = Math.sqrt(100);
    private double[] degrees = new double[]{30,-30,-150,150};
    
    public Ruedas ( double cX, double x, double cY, double y, double angle) {
        wheelAng = (int)( angle+Math.toDegrees(Math.atan2(y,x)));
        wheelRad = (int) Math.sqrt(x*x + y*y);
        for (int i = 0; i < 4; i++) {
            degrees[i] += angle;
            intX[i] = (int) (radio*cos(Math.toRadians(degrees[i])));
            intY[i] = (int) (radio*sin(Math.toRadians(degrees[i])));
            
            intX[i] += cX + (int) (wheelRad*cos(Math.toRadians(wheelAng)));
            intY[i] += cY + (int) (wheelRad*sin(Math.toRadians(wheelAng)));
        }
    
    }
    /**
     *  Este método crea el movimiento de las ruedas
     * 
     * @param cX    Es la posición X del centro del auto
     * @param cY    Es la posición Y del centro del auto
     * @param angle Es el ángulo en el que giran las ruedas
     * @param extra Es el ángulo extra de la ruedas delanteras en la que va a girar el auto
     */
    public void movimientoRuedas(double cX, double cY, double angle, double extra){
        wheelAng += angle;
        for (int i = 0; i < 4; i++) {
            degrees[i] += angle;
            intX[i] = (int) (radio*cos(Math.toRadians(degrees[i]+extra)));
            intY[i] = (int) (radio*sin(Math.toRadians(degrees[i]+extra)));
            
            intX[i] += cX + (int) (wheelRad*cos(Math.toRadians(wheelAng)));
            intY[i] += cY + (int) (wheelRad*sin(Math.toRadians(wheelAng)));
            //System.out.println(i +": "+ intX[i] + " _ " + intY[i]);
        }
    }
    /**
     *  Este método pinta las ruedas
     * 
     * @param g Recibe gráfico para pintar la pista
     */
    
    public void paint(Graphics g){
        Graphics2D tire = (Graphics2D)g;
        tire.setColor(Color.black);           //upper left tire
        tire.fillPolygon(intX, intY, 4);
    }
}
