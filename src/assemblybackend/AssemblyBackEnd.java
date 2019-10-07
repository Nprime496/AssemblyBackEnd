/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.memory.Memory;
import assembly.memory.MyDesktop;

import static assembly.TwoAdressAssembly.*;
import static assembly.OneAdressAssembly.*;
import static assembly.ZeroAdressAssembly.*;
import static assembly.ThreeAdressAssembly.*;
import assembly.ZeroAdressAssembly;
import static assembly.memory.MyDesktop.*;
import assembly.memory.Stack;


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
        computerMemory.store("A",16);
        computerMemory.store("B",10);
        //add("C","B");
        add("A","B");
        div("A","B");
        print("A");
    }
}
