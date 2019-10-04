/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.Memory;
import assembly.MyDesktop;
import assembly.TwoAdressAssembly;
import assembly.ZeroAdressAssembly;


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
        ZeroAdressAssembly ZeroAdresse=new ZeroAdressAssembly(ComputerMemory);
        TwoAdressAssembly DeuxAdresse=new TwoAdressAssembly(ComputerMemory);
        ComputerMemory.store("A",16);
        ComputerMemory.store("B",-10);
        ZeroAdresse.push("A");
        ZeroAdresse.push("B");
        ZeroAdresse.push("A");
        ZeroAdresse.push("B");
        ZeroAdresse.add();
        ZeroAdresse.mpy();
        ZeroAdresse.pop("A");
        DeuxAdresse.add("A","B");
        ZeroAdresse.print("A");
        //ZeroAdresse.print("B");
    }
}
