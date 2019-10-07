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
public class Accumulator {
    private int value;
    public Accumulator()
    {
        this.value=(int)(Math.random()*(Math.random()*100+Math.random()*50));//juste pour donner une valeur aleatoire
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
