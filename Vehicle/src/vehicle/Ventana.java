
package vehicle;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    // Crear un nuevo panel.
    PanelPrincipal panel = new PanelPrincipal();
    public Ventana(){
        this.setSize(700, 700);     // Establecemos el tamaño de la ventana.
        this.setResizable(false);   // Establecer su tamaño estático.
        setTitle("Vehicle");    // Definir el titulo de la Ventana como "Vehicle".
        this.add(panel);            // Añadir el panel a la ventana.
        setLocationRelativeTo(null);// Posicionar la ventana en el centro.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // Cierra la ventana
        
    }
}