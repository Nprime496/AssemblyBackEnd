/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.memory;

/**
 *
 * @author _Nprime496_
 */
public class Flag {
    private int value;
    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value!=0)
            this.value = Math.abs(value)/value;
        else
            this.value=0;
    }
    
}
