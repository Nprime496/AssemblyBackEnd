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
public class AssemblyTwoAdress extends Assembly{

    public static void add(String op1,String op2)
    {
        MyDesktop.getMemory().store(op1,MyDesktop.getMemory().retrieve(op1)+MyDesktop.getMemory().retrieve(op2));
    }
    public static void sub(String op1,String op2)
    {
        MyDesktop.getMemory().store(op1,MyDesktop.getMemory().retrieve(op1)-MyDesktop.getMemory().retrieve(op2));
    }
    public static void mpy(String op1,String op2)
    {
        MyDesktop.getMemory().store(op1,MyDesktop.getMemory().retrieve(op1)*MyDesktop.getMemory().retrieve(op2));
    }
    public static void div(String op1,String op2)
    {
        MyDesktop.getMemory().store(op1,MyDesktop.getMemory().retrieve(op1)/MyDesktop.getMemory().retrieve(op2));
    }
    
}
