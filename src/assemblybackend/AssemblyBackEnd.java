/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.memory.Memory;
import assembly.memory.MyDesktop;
import assembly.TwoAdressAssembly;
import assembly.ZeroAdressAssembly;
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
        Memory ComputerMemory=MyDesktop.getMemory();
        Stack ComputerStack=MyDesktop.getStack();
        ComputerMemory.store("A",16);
        ComputerMemory.store("B",-10);
        MyDesktop.printMessage("Tout fonctionne!!");
    }
}
