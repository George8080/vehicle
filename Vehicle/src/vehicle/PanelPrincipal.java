
package vehicle;

// Importar librerias necesarias para el funcionamiento del codigo
import CarCreation.Auto;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class PanelPrincipal extends JPanel implements KeyListener, ActionListener{
    private JButton button1;
    
    private JTextArea width;
    private JButton widthP;
    private JButton widthM;
    
    private JTextArea high;
    private JButton highP;
    private JButton highM;
    
    private JTextArea avenue;
    private JButton avenueP;
    private JButton avenueM;
    private JButton min;
    private JButton max;
    
    Auto car = new Auto(Color.red, 170,250);
    Pista road = new Pista();
    
    private boolean gameplay = false;
    private Timer t;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private double vel = 0;
    private double grados = 0;

    public PanelPrincipal () {
        this.setLayout(null);
        this.button1 = new JButton();
        
        this.width =  new JTextArea("        Ancho");
        this.high =   new JTextArea("        Largo");
        this.avenue = new JTextArea("       Grosor");
        this.width.setBackground(new Color(235,235,235));
        this.high.setBackground(new Color(235,235,235));
        this.avenue.setBackground(new Color(235,235,235));
        this.widthP = new JButton("<html>+</html>");
        this.widthM = new JButton("<html>-</html>");
        this.highP = new JButton("<html>+</html>");
        this.highM = new JButton("<html>-</html>");
        this.avenueP = new JButton("<html>+</html>");
        this.avenueM = new JButton("<html>-</html>");
        this.min = new JButton("<html><p>Establecer</p><p>Mínimos   </p></html>");
        this.max = new JButton("<html><p>Establecer</p><p>Máximos   </p></html>");
        
        this.button1.setText("Modo Carrera");
        this.button1.addActionListener(this);
        this.button1.setFocusable(false);
        this.button1.setBounds(10, 655, 150, 35);
        
        
        this.min.setBounds(213, 655, 82, 35);
        this.max.setBounds(300, 655, 82, 35);
        this.width.setBounds(387, 655, 82, 20);
        this.widthP.setBounds(387, 675, 41, 15);
        this.widthM.setBounds(428, 675, 41, 15);
        this.high.setBounds(474, 655, 82, 20);
        this.highP.setBounds(474, 675, 41, 15);
        this.highM.setBounds(515, 675, 41, 15);
        this.avenue.setBounds(561, 655, 82, 20);
        this.avenueP.setBounds(561, 675, 41, 15);
        this.avenueM.setBounds(602, 675, 41, 15);
        
        this.widthP.addActionListener(this);
        this.widthM.addActionListener(this);
        this.highP.addActionListener(this);
        this.highM.addActionListener(this);
        this.avenueP.addActionListener(this);
        this.avenueM.addActionListener(this);
        this.min.addActionListener(this);
        this.max.addActionListener(this);
        
        this.add(button1);
        this.add(widthP);
        this.add(widthM);
        this.add(width);
        this.add(highP);
        this.add(highM);
        this.add(high);
        this.add(avenueP);
        this.add(avenueM);
        this.add(avenue);
        this.add(max);
        this.add(min);
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
        road.paint(g);
        if(gameplay) car.paint(g);
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
    
    public void activateConfigButtons(boolean b){
        this.widthP.setVisible(b);
        this.widthM.setVisible(b);
        this.highP.setVisible(b);
        this.highM.setVisible(b);
        this.avenueP.setVisible(b);
        this.avenueM.setVisible(b);
        this.width.setVisible(b);
        this.high.setVisible(b);
        this.avenue.setVisible(b);
        this.min.setVisible(b);
        this.max.setVisible(b);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == widthP){
            road.setSize(-5, 0, 0);
        }
        if(e.getSource() == widthM){
            road.setSize(5, 0, 0);
        }
        if(e.getSource() == highP){
            road.setSize(0, -5, 0);
        }
        if(e.getSource() == highM){
            road.setSize(0, 5, 0);
        }
        if(e.getSource() == avenueP){
            road.setSize(0, 0, 1);
        }
        if(e.getSource() == avenueM){
            road.setSize(0, 0, -1);
        }
        if(e.getSource() == min){
            road.setMin();
        }
        if(e.getSource() == max){
            road.setMax();
        }
        
        if(e.getSource() == button1){
            if(gameplay){
                System.out.println("Edicion iniciada");
                this.button1.setText("Modo Carrera");
                this.activateConfigButtons(true);
                gameplay = false;
            }
            else{
                System.out.println("Juego iniciado");
                this.activateConfigButtons(false);
                car = new Auto(Color.red, 170,250);
                vel = 0;
                grados = 0;
                gameplay = true;
                this.button1.setText("Modo Edicion");
            }
        }
        if(e.getSource() == t && gameplay){
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