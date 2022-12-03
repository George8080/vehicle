
package vehicle;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements KeyListener, ActionListener{
    private JButton button1;
    Auto car = new Auto(Color.red, 170,250);
    Pista road = new Pista();
    Solera beam = new Solera();
    //Ruedas tire= new Ruedas(170, 250);
    private boolean gameplay = false;
    private Timer t;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private double vel = 0;
    private double grados = 0;

    public PanelPrincipal () {
        this.button1 = new JButton();
        this.button1.setText("Modo Carrera");
        this.button1.addActionListener(this);
        this.button1.setFocusable(false);
        this.button1.setLayout(null);
        this.button1.setBounds(-90, 0, 200, 50);
        this.add(button1);
        this.t = new Timer(16, this);
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
        if(gameplay) car.paint(g);
        //button1.paint(g);
        if(!gameplay) this.requestFocus();
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
        if(e.getSource() == button1)
        {
            System.out.println("Juego iniciado");
            car = new Auto(Color.red, 170,250);
            vel = 0;
            grados = 0;
            gameplay = true;
            this.button1.setText("Reiniciar");
        }
        else if(e.getSource() == t && gameplay){
            if(down){
                if(vel<=1.75) vel+=0.025;
                if(vel>1.75) vel = 2;
            }
            else if(up){
                if(vel>=-2.0) vel-=0.05;
                if(vel<-2.0) vel = -2.0;
            }if(!up && !down){
                if(vel < 0){
                    vel+=0.03;
                    if(vel > 0) vel = 0;
                }
                else if(vel > 0){
                    vel-=0.03;
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
        }
        this.repaint();
    }
}