

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
        
        Graphics2D solera = (Graphics2D)g;  
         
        solera.setColor(Color.black);   //solera externa
        solera.fillOval(20, 20, 620, 620);     
        
        solera.setColor(Color.black);  //solera interna
        solera.fillOval(200, 200, 300, 300);
        
        road.setColor(Color.gray);      //pista
        road.fillOval(30, 30, 600, 600);     
        
        road.setColor(new Color(100,255,100));    //pasto
        road.fillOval(200, 200, 270, 270);
        
    }
}