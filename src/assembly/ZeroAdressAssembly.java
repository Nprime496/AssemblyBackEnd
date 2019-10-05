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
public class ZeroAdressAssembly extends Assembly {
    
    public static void add() 
    {
        MyDesktop.getStack().setSubHead(MyDesktop.getStack().getHead()+MyDesktop.getStack().getSubHead());
        try
        {
             MyDesktop.getStack().pop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void sub()
    {
        //soustraction
        MyDesktop.getStack().setSubHead(-MyDesktop.getStack().getHead()+MyDesktop.getStack().getSubHead());
        try
        {
             MyDesktop.getStack().pop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void div()
    {
        MyDesktop.getStack().setSubHead(MyDesktop.getStack().getSubHead()/MyDesktop.getStack().getHead());
        try
        {
             MyDesktop.getStack().pop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void mpy() {
        //multiplication
        MyDesktop.getStack().setSubHead(MyDesktop.getStack().getSubHead()*MyDesktop.getStack().getHead());
        try
        {
             MyDesktop.getStack().pop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
