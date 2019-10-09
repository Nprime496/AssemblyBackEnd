/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.parser;

import assembly.interpreter.InterpreterParser;
import assembly.interpreter.Instruction;
import assembly.interpreter.InstructionOperation;
import java.util.Map;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
        InterpreterParser instance = new InterpreterParser(5);
        Pair<String, String> expResult = new Pair("dfd "," operation");
        
        Pair<String, String> result = instance.SplitAdress(instruction);

        assertEquals(expResult.hashCode(), result.hashCode());

    }

    /**
     * Test of SplitOperation method, of class Parser.
     */
    @Test
    public void testSplitOperation() {
        System.out.println("SplitOperation");
        String instruction = "gfg fgsf";
        InterpreterParser instance = new InterpreterParser(9);
        Pair<String, String> expResult = new Pair("gfg","fgsf");
        Pair<String, String> result = instance.SplitOperation(instruction);
        assertEquals(expResult.hashCode(), result.hashCode());

    }

    /**
     * Test of SplitOperands method, of class Parser.
     */
    @Test
    public void testSplitOperands() {
        System.out.println("SplitOperands");
        String instruction = "1,3,de";
        InterpreterParser instance = new InterpreterParser(3);
        String[] expResult = {"1","3","de"};
        String[] result = instance.SplitOperands(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SplitBranch method, of class Parser.
     */
    @Test
    public void testSplitBranch() {
        System.out.println("SplitBranch");
        String instruction = "br dd";
        InterpreterParser instance = new InterpreterParser(4);
        Pair<String, String> expResult = new Pair("br","dd");
        Pair<String, String> result = instance.SplitBranch(instruction);
        assertEquals(expResult.hashCode(), result.hashCode());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



    /**
     * Test of SplitInstruction method, of class Parser.
     */
    @Test
    public void testSplitInstruction() {
        System.out.println("SplitInstruction");
        String instruction = "a:add c,d";
        InterpreterParser instance = new InterpreterParser(2);
        String[] operands={"c","d"};
        Instruction expResult = new InstructionOperation("a","add",operands);
        Instruction result = instance.SplitInstruction(instruction);
        //assertEquals(expResult, result);
        //System.out.println(result);
        Assert.assertEquals(expResult, result);
        //Assert.ass
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
