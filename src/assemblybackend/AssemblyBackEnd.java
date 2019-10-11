/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.memory.Memory;
import assembly.memory.MyDesktop;

import static assembly.AssemblyTwoAdress.*;
import assembly.filemanager.FileManager;
import assembly.filemanager.Parser;
import assembly.interpreter.Interpreter;
import assembly.interpreter.InterpreterTwoAdress;
import static assembly.memory.MyDesktop.*;


/**
 *
 * @author _Nprime496_
 */
public class AssemblyBackEnd {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Memory computerMemory=MyDesktop.getMemory();
        InterpreterTwoAdress interpreter=new InterpreterTwoAdress();
        computerMemory.store("A",6);
        computerMemory.store("B",2);
        computerMemory.store("X",5);
        Test();
        //interpreter.interpretTextInstructions("l2: div A,B \n mpy A,X");
        //System.out.println(MyDesktop.getMemory().retrieve("2"));
        print("A");
    }
    public static void Test()
    {
        FileManager manager=new FileManager(new Parser(3));
        Interpreter interpreter=new InterpreterTwoAdress();
        String instruction="l2: div A,B \n mpy A,X \n sub A,B \n stop ";
        manager.loadInMemory(instruction);
        interpreter.InterpretMemoryInstructions();
    }
}
