

package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author jorge
 */
public class Pista {
    private int width;
    private int height;
    private int breadth;
    
    public Pista(){
        width = 0;
        height = 0;
        breadth = 175;
        //breadth = 1;
    }
    
    public void paint(Graphics g){
        Graphics2D road = (Graphics2D)g;
        Graphics2D solera = (Graphics2D)g;  
         
        solera.setColor(Color.darkGray);   //solera externa
        solera.fillOval(width, height, 643-(2*width), 643-(2*height));     
        
        /*solera.setColor(Color.black);  //solera externa
        solera.fillOval(200, 200, 300, 300);
        */
        road.setColor(Color.gray);      //pista
        road.fillOval(10+width, 10+height, 623-(2*width), 623-(2*height));  
        
        
        road.setColor(Color.darkGray);    //solera interna
        road.fillOval(10+width/2+breadth, breadth+10+height/2, 623-(2*breadth)-width, 623-(2*breadth)-height);
        
        road.setColor(new Color(100,255,100));    //pasto
        road.fillOval(20+width/2+breadth, breadth+20+height/2, 603-(2*breadth)-width, 603-(2*breadth)-height);
    }
    
    public void setSize(int x, int y, int z){
        width += x;
        if(width > 185)
            width = 185;
        else if(width < 0)
            width = 0;
        
        height += y;
        if(height > 185)
            height = 185;
        else if(height < 0)
            height = 0;
        
        breadth += z;
        /*
        if(breadth > 10) breadth = 10;
        else if(breadth < 0) breadth = 0;
        */
        if(breadth > 195)
            breadth = 190;
        else if(breadth < 160)
            breadth = 160;
        
    }
    public void setMin(){
        width = 185;
        height = 185;
        breadth = 195;
    }
    public void setMax(){
        width = 0;
        height = 0;
        breadth = 160;
    }
}