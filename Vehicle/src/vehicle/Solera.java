
package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author jorge y danino
 */
public class Solera {
    public Solera(){}
    
    public void paint(Graphics g){
        Graphics2D solera = (Graphics2D)g;  
        solera.setColor(Color.black);   //solera externa
        solera.fillOval(20, 20, 620, 620);     
        
        solera.setColor(Color.black);  //solera interna
        solera.fillOval(195, 195, 290, 290);
        
        
    }
}
