

package vehicle;

import CarCreation.Auto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Daniela Novoa
 * @author Jorge Santis
 */
public class Pista {
    private int width;
    private int height;
    private int breadth;
    Auto car= new Auto(Color.red, 170, 250);
    
    public Pista(){  
        width = 10;
        height = 10;
        breadth = 175;

    }
    
    public void paint(Graphics g){
        Graphics2D road = (Graphics2D)g;
                 
        road.setColor(Color.black);   //solera externa
        road.fillOval(width-10, height-10, 665-(2*width), 665-(2*height));   
        
        road.setColor(Color.darkGray);   //limite de pista  externo
        road.fillOval(width, height, 643-(2*width), 643-(2*height));     
        
        road.setColor(Color.gray);      //pista
        road.fillOval(10+width, 10+height, 623-(2*width), 623-(2*height));         
        
        road.setColor(Color.darkGray);    //limite de pista interno
        road.fillOval(10+width/2+breadth, breadth+10+height/2, 623-(2*breadth)-width, 623-(2*breadth)-height);
        
        road.setColor(Color.black);           //solera interna
        road.fillOval(15+width/2+breadth, breadth+15+height/2, 613-(2*breadth)-width, 613-(2*breadth)-height);
        
        road.setColor(new Color(100,255,100));    //pasto
        road.fillOval(25+width/2+breadth, breadth+25+height/2, 593-(2*breadth)-width, 593-(2*breadth)-height);
    }
    /**
     * 
     * @param x
     * @param y
     * @param z 
     */
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
    /**
     * Este método establece el mínimo tamaño de la pista
     */
    public void setMin(){
        width = 185;
        height = 185;
        breadth = 195;
    }
    /**
     * Este metodo establece el maximo tamaño de la pista
     */
    public void setMax(){
        width = 0;
        height = 0;
        breadth = 160;
    }
    public double Perimeter(){
        double area=Math.PI*(width+height);
        return area;
    }
}