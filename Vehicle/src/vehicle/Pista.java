

package vehicle;

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
    
    public Pista(){  
        width = 10;
        height = 10;
        breadth = 160;

    }
    /**
     *  ESye método pinta la pista
     * 
     * @param g Recibe gráfico para pintar la pista
     */
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
     *  Este método sirve para redefinir el tamaño de la pista de acuerdo
     *  a los cambios entregados por el usuario
     * 
     * @param x Recibe la coordenada x del cambio de tamaño
     * @param y Recibe la coordenada y del cambio de tamaño
     * @param z Recibe la coordenada z del cambio de tamaño
     */
    public void setSize(int x, int y, int z){
        width += x;
        if(width > 185)
            width = 185;
        else if(width < 10)
            width = 10;
        
        height += y;
        if(height > 185)
            height = 185;
        else if(height < 10)
            height = 10;
        
        breadth += z;
        /*
        if(breadth > 10) breadth = 10;
        else if(breadth < 0) breadth = 0;
        */
        if(breadth > 195)
            breadth = 195;
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
        width = 10;
        height = 10;
        breadth = 160;
    }
    /**
     *  Este método, como los tres siguientes,  define n  elipses en los límites de la pista
     * para que sirvan de soleras
     * 
     * @param Y Recibe la coordenada Y del centro del auto, en
     * la clase PanelPrincipal
     * 
     * @return Devuelve la coordenada X del centro de la solera exterior con respecto
     *  a la solera exterior de la pista
     * 
     */
    public double elipse_X(double Y){
        double A= 583-(2*width);//-height;
        double B= 583 - (2 * height);//-width;
        A= (A/2)*(A/2);
        B= (B/2)*(B/2);
        
        double X = A - (A*Y*Y) / (B);
        //System.out.println("X externo ideal: "+X);
        return X;
    }/**
     * 
     * @param X Recibe como coordena X el centro del auto con respecto 
     *   a la solera exterior de la pista, en la clase Principal
     * 
     * @return Devuelve la coordenada Y del centro de la solera exterior con respecto
     *  a la pista
     */
    public double elipse_Y(double X){
        double A= 583-(2*width);//-height;
        double B= 583 - (2 * height);//-width;
        A= (A/2)*(A/2);
        B= (B/2)*(B/2);
        
        double Y = B - (B*X*X) / A;
        return Y;
    }/**
     * 
     * @param y Recibe como coordenada y el centro del auto
     *   con respecto al centro de la pista, en la clase Principal
     * 
     * @return  Devuelve la coordenada x del centro de la solera interior con respecto
     *  a la pista
     */
        public double elipse_x(double y){
         double a = 683-(2*breadth)-width;
         double b= 683 - (2 * breadth) - height ;
         a = (a/2)*(a/2);
         b = (b/2)*(b/2);
         
         double x= a - ((a)*y*y) / (b);
         return x;
    }/**
     * 
     * @param x Recibe como parametro la coordenada X el centro
     *  del auto con respecto al centro de la pista, en la clase PanelPrincipal
     * 
     * @return Devuelve la coordenada  y del centro de la solera interior con respecto 
     *  a la pista
     *  
     */
    public double elipse_y(double x){
         double a = 683-(2 * breadth) - height;
         double b = 683-(2 * breadth) - width;
         a = (a/2)*(a/2);
         b = (b/2)*(b/2);
         
         double y= b - ((b)*x*x) / (a);
         return y;
    }
    /**
     * Getter de Width
     * @return Devuelve el modificador del largo de la pista
     */
    public int getWidth(){
        return this.width;
    }
    
    /**
     * Getter de Height
     * @return Devuelve el modificador del alto de la pista
     */
    public int getHeight(){
        return this.height;
    }
    
    /**
     * Getter de Breadth
     * @return Devuelve el modificador del grosor de la pista
     */
    public int getBreadth(){
        return this.breadth;
    }
}