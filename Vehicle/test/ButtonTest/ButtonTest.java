/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ButtonTest;

import vehicle.PanelPrincipal;
import vehicle.Pista;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class ButtonTest {
    private PanelPrincipal panel;
    private Pista pista;
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
        pista = new Pista();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMax() throws Exception {
        System.out.println("Boton de Maximo");
        pista.setMax();
        if(pista.getWidth()!=0 || pista.getHeight()!=0 || pista.getBreadth() != 160)
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
        if(pista.getWidth()!=185 || pista.getHeight()!=185 || pista.getBreadth() != 190 )
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
        if(pista.getWidth()!=0 || pista.getHeight()!=0 || pista.getBreadth() != 160)
            throw new Exception("No se mantiene al margen maximo");
        else
            System.out.println("- Se mantiene al margen maximo");
    }
}
