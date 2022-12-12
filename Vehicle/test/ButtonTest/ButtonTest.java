
package ButtonTest;

import vehicle.*;
import CarCreation.*;
import java.awt.Color;
import vehicle.Pista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Daniela Novoa
 * @author Jorge Santis
 */
public class ButtonTest {
    private PanelPrincipal panel;
    private Pista pista;
    private Auto auto;
    
    public ButtonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        panel = new PanelPrincipal();
        auto = new Auto(Color.red, 0,250);
        pista = new Pista();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMax() throws Exception {
        System.out.println("Boton de Maximo");
        pista.setMax();
        if(pista.getWidth()!=10 || pista.getHeight()!=10 || pista.getBreadth() != 160)
            throw new Exception("Variables Incorrectas");
        else
            System.out.println("- Variables Correctas");
    }
    
    @Test
    public void testMin() throws Exception {
        System.out.println("Boton de Minimo");
        pista.setMin();
        if(pista.getWidth()!=185 || pista.getHeight()!=185 || pista.getBreadth() != 195)
            throw new Exception("Variables Incorrectas");
        else
            System.out.println("- Variables Correctas");
    }
    
    @Test
    public void testMinLimits() throws Exception {
        System.out.println("Restando al Limite minimo");
        pista.setMin();
        pista.setSize(5, 5, 5);
        /*
        System.out.println(pista.getWidth());
        System.out.println(pista.getHeight());
        System.out.println(pista.getBreadth());
        */
        if(pista.getWidth()!=185 || pista.getHeight()!=185 || pista.getBreadth() != 195 )
            throw new Exception("No se mantiene al margen minimo");
        else
            System.out.println("- Se mantiene al margen minimo");
    }
    
    @Test
    public void testMaxLimits() throws Exception {
        System.out.println("Restando al Limite maximo");
        pista.setMax();
        pista.setSize(-5, -5, -5);
        /*
        System.out.println(pista.getWidth());
        System.out.println(pista.getHeight());
        System.out.println(pista.getBreadth());
        */
        if(pista.getWidth()!=10 || pista.getHeight()!=10 || pista.getBreadth() != 160)
            throw new Exception("No se mantiene al margen maximo");
        else
            System.out.println("- Se mantiene al margen maximo");
    }
    
    @Test
    public void testLimiteAutoX() throws Exception {
        auto.ColisionX(10);
        System.out.println(auto.getCenterX());
        if(auto.getCenterX()!=312.0)
            throw new Exception("No se mantiene en la pista con respecto al eje X.");
        else
            System.out.println("- Se mantiene en la pista con respecto al eje X.");
        
    }
    @Test
    public void testLimiteAutoY() throws Exception {
        auto.ColisionY(10);
        if(auto.getCenterY()!=312.0)
            throw new Exception("No se mantiene en la pista con respecto al eje Y.");
        else
            System.out.println("- Se mantiene en la pista con respecto al eje Y.");
        
    }
}
