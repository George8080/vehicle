
package GUI;

import javax.swing.JFrame;
import vehicle.PanelPrincipal;

public class Ventana extends JFrame{
    // Crear un nuevo panel.
    private static Ventana vent = new Ventana();
    PanelPrincipal panel = new PanelPrincipal();
    private Ventana(){
        this.setSize(660, 735);     // Establecemos el tamaño de la ventana.
        this.setResizable(false);   // Establecer su tamaño estático.
        setTitle("Vehicle");    // Definir el titulo de la Ventana como "Vehicle".
        this.add(panel);            // Añadir el panel a la ventana.
        setLocationRelativeTo(null);// Posicionar la ventana en el centro.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // Cierra la ventana
    }
    public static Ventana getInstancia( ){
        return  vent;
    }
}