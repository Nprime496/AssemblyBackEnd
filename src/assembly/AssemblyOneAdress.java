/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

import assembly.memory.MyDesktop;

/**
 *
 * @author _Nprime496_
 */
public class AssemblyOneAdress extends Assembly {
    //MyDesktop.getMemory().setFlag(accumulator);
    //mettre à jour la mémoire flag
    
    public static void store(String adress)
    {
        MyDesktop.getMemory().store(adress,MyDesktop.getAccmulator().getValue());
    }
    public static void load(String adress)
    {
        MyDesktop.getAccmulator().setValue(MyDesktop.getMemory().retrieve(adress));
    }
    public static void add(String adress)
    {
        MyDesktop.getAccmulator().setValue(MyDesktop.getAccmulator().getValue()+MyDesktop.getMemory().retrieve(adress));
    }
    public static void sub(String adress)
    {
        MyDesktop.getAccmulator().setValue(MyDesktop.getAccmulator().getValue()-MyDesktop.getMemory().retrieve(adress));
    }
    public static void mpy(String adress)
    {
        MyDesktop.getAccmulator().setValue(MyDesktop.getAccmulator().getValue()*MyDesktop.getMemory().retrieve(adress)); 
    }
    public static void div(String adress)
    {
        MyDesktop.getAccmulator().setValue(MyDesktop.getAccmulator().getValue()/MyDesktop.getMemory().retrieve(adress));
    }
}
