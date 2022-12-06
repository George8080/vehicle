

package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author jorge
 */
public class Pista {
    private int large;
    private int high;
    private int width;
    public Pista(){
        large = 0;
        high = 0;
        width = 175;
        //width = 1;
    }
    
    public void paint(Graphics g){
        Graphics2D road = (Graphics2D)g;
        Graphics2D solera = (Graphics2D)g;  
         
        solera.setColor(Color.darkGray);   //solera externa
        solera.fillOval(large, high, 643-(2*large), 643-(2*high));     
        
        /*solera.setColor(Color.black);  //solera externa
        solera.fillOval(200, 200, 300, 300);
        */
        road.setColor(Color.gray);      //pista
        road.fillOval(10+large, 10+high, 623-(2*large), 623-(2*high));  
        
        
        road.setColor(Color.darkGray);    //solera interna
        road.fillOval(10+large/2+width, width+10+high/2, 623-(2*width)-large, 623-(2*width)-high);
        
        road.setColor(new Color(100,255,100));    //pasto
        road.fillOval(20+large/2+width, width+20+high/2, 603-(2*width)-large, 603-(2*width)-high);
    }
    
    public void setSize(int x, int y, int z){
        large += x;
        if(large > 185)
            large = 185;
        else if(large < 0)
            large = 0;
        
        high += y;
        if(high > 185)
            high = 185;
        else if(high < 0)
            high = 0;
        
        width += z;
        /*
        if(width > 10) width = 10;
        else if(width < 0) width = 0;
        */
        if(width > 195)
            width = 190;
        else if(width < 160)
            width = 160;
        
    }
    public void setMin(){
        large = 185;
        high = 185;
        width = 195;
    }
    public void setMax(){
        large = 0;
        high = 0;
        width = 160;
    }
}