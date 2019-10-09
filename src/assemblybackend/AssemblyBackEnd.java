/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.memory.Memory;
import assembly.memory.MyDesktop;

import static assembly.AssemblyTwoAdress.*;
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
        computerMemory.store("A",16);
        computerMemory.store("B",4);
        computerMemory.store("X",17);
        //interpreter.interpretOperation("l1: sub A,B");
        //interpreter.interpretOperation("mpy A,X");
        //interpreter.interpretOperation("l2: div A,B");
        interpreter.interpretText("l2: div A,B\nmpy A,X");
        print("A");
    }
}
