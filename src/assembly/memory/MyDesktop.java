/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.memory;

import assembly.memory.Memory;

/**
 *
 * @author _Nprime496_
 */
public class MyDesktop {
    private static Stack stack;
    private static Memory memory;
    private static Accumulator accumulator;
    public static Accumulator getAccmulator()
    {
        if(accumulator==null)
            accumulator=new Accumulator();
        return accumulator;
    }
    public static Memory getMemory()
    {
        if(memory==null)
            memory=new Memory();
        return memory;
    }
    public static Stack getStack()
    {
        if(stack==null)
            stack=new Stack();
        return stack;
    }
    public static void printMessage(String message)
    {
        System.out.println(message);
    }
    public static void print(String adress) {
        System.out.println(MyDesktop.getMemory().retrieve(adress));
    }
}
