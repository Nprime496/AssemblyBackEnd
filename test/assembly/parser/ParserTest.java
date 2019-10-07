/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.parser;

import java.util.Map;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author _Nprime496_
 */
public class ParserTest {
    
    public ParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SplitAdress method, of class Parser.
     */
    @Test
    public void testSplitAdress() {
        System.out.println("SplitAdress");
        String instruction = "dfd : operation";
        Parser instance = new Parser(5);
        Pair<String, String> expResult = new Pair("dfd "," operation");
        
        Pair<String, String> result = instance.SplitAdress(instruction);
        //System.out.println(result.getKey()+"-");
        assertEquals(expResult.hashCode(), result.hashCode());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SplitOperation method, of class Parser.
     */
    @Test
    public void testSplitOperation() {
        System.out.println("SplitOperation");
        String instruction = "gfg fgsf";
        Parser instance = new Parser(9);
        Pair<String, String> expResult = new Pair("gfg","fgsf");
        Pair<String, String> result = instance.SplitOperation(instruction);
        assertEquals(expResult.hashCode(), result.hashCode());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SplitOperands method, of class Parser.
     */
    @Test
    public void testSplitOperands() {
        System.out.println("SplitOperands");
        String instruction = "";
        Parser instance = null;
        String[] expResult = null;
        String[] result = instance.SplitOperands(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SplitBranch method, of class Parser.
     */
    @Test
    public void testSplitBranch() {
        System.out.println("SplitBranch");
        String instruction = "";
        Parser instance = null;
        Pair<String, String> expResult = null;
        Pair<String, String> result = instance.SplitBranch(instruction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of SplitInstruction method, of class Parser.
     */
    @Test
    public void testSplitInstruction() {
        System.out.println("SplitInstruction");
        String instruction = "";
        Parser instance = null;
        Map expResult = null;
        Map result = instance.SplitInstruction(instruction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
