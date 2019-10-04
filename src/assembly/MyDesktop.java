/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

/**
 *
 * @author _Nprime496_
 */
public class MyDesktop {
    private static Memory memory;
    public static Memory getMemory()
    {
        if(memory==null)
            return new Memory();
        return memory;
    }
    
}
