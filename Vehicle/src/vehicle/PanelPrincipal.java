
package vehicle;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.PI;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements KeyListener, ActionListener{
    Auto car = new Auto(Color.red, 170,250);
    Pista road = new Pista();
    Solera beam = new Solera();
    //Ruedas tire= new Ruedas(170, 250);
    private Timer t;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private int vel = 0;
    private double grados = 0;

    public PanelPrincipal () {
        this.t = new Timer(100, this);
        this.setBackground(new Color(100,255,100));
        this.addKeyListener(this);
        this.setFocusable(true);
        
        t.addActionListener(this);
        t.start();
    }
    
    @Override
    public void paint (Graphics g) {    // Metodo para imprimir en la interfaz.
        
        super.paint(g); 
        beam.paint(g);      
        road.paint(g);
        car.paint(g);
        this.requestFocus();
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int keyI = e.getKeyCode();
        char keyC = e.getKeyChar();
        int keyL = e.getKeyLocation();
        System.out.println("Tecla presionada: "+keyI+" _ " + keyC + " _ " + keyL);
        if(keyI==KeyEvent.VK_W || keyI==KeyEvent.VK_UP){
            System.out.println("Avanzando...");
            up = true;
        }
        if(keyI==KeyEvent.VK_S || keyI==KeyEvent.VK_DOWN){
            System.out.println("Retrocediendo...");
            down = true;
        }
        if(keyI==KeyEvent.VK_A || keyI==KeyEvent.VK_LEFT){
            System.out.println("Izquierda...");
            left = true;
        }
        if(keyI==KeyEvent.VK_D || keyI==KeyEvent.VK_RIGHT){
            System.out.println("Derecha...");
            right = true;
        }
        this.repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int keyI = e.getKeyCode();
        char keyC = e.getKeyChar();
        int keyL = e.getKeyLocation();
        System.out.println("Tecla soltada: "+keyI+" _ " + keyC + " _ " + keyL);
        if(keyI==KeyEvent.VK_W || keyI==KeyEvent.VK_UP){
            System.out.println("Cancelar avanzando...");
            up = false;
        }
        if(keyI==KeyEvent.VK_S || keyI==KeyEvent.VK_DOWN){
            System.out.println("Cancelar retrocediendo...");
            down = false;
        }
        if(keyI==KeyEvent.VK_A || keyI==KeyEvent.VK_LEFT){
            System.out.println("Cancelar izquierda...");
            left = false;
        }
        if(keyI==KeyEvent.VK_D || keyI==KeyEvent.VK_RIGHT){
            System.out.println("Cancelar derecha...");
            right = false;
        }
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyI = e.getKeyCode();
        char keyC = e.getKeyChar();
        int keyL = e.getKeyLocation();
        System.out.println("Tecla tipeada: "+keyI+" _ " + keyC + " _ " + keyL);
        if(keyI==KeyEvent.VK_W) System.out.println("T: W");
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(down){
            if(vel<=10) vel+=1;
            if(vel>10) vel = 10;
        }
        else if(up){
            if(vel>=-10) vel-=1;
            if(vel<-10) vel = -10;
        }if(!up && !down){
            if(vel < 0){
                vel+=0.5;
                if(vel > 0) vel = 0;
            }
            else if(vel > 0){
                vel-=0.5;
                if(vel < 0) vel = 0;
            }
        }
        
        if(left){
            if(grados>=-5) grados-=0.5;
            if(grados<-5) grados = -5;
        }
        else if(right){
            if(grados<=5) grados+=0.5;
            if(grados>5) grados = 5;
        }if(!left && !right){
            if(grados < 0){
                grados+=0.5;
                if(grados > 0) grados = 0;
            }
            else if(grados > 0){
                grados-=0.5;
                if(grados < 0) grados = 0;
            }
        }
        
        car.setXY(-vel, grados);
        this.repaint();
    }
}