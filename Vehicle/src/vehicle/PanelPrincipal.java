
package vehicle;

// Importar librerias necesarias para el funcionamiento del codigo
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelPrincipal extends JPanel implements KeyListener{
    Auto car = new Auto(Color.red);
    Pista road = new Pista();

    public PanelPrincipal () {
        this.setBackground(new Color(100,255,100));
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    
    @Override
    public void paint (Graphics g) {    // Metodo para imprimir en la interfaz.
        super.paint(g); 
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
        if(keyI==KeyEvent.VK_W) System.out.println("P: W");
        this.repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        int keyI = e.getKeyCode();
        char keyC = e.getKeyChar();
        int keyL = e.getKeyLocation();
        System.out.println("Tecla soltada: "+keyI+" _ " + keyC + " _ " + keyL);
        if(keyI==KeyEvent.VK_W) System.out.println("R: W");
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
}