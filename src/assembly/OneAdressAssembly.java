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
public class OneAdressAssembly extends Assembly {
    //this.memory.setFlag(accumulator);
    //mettre à jour la mémoire flag
    private int accumulator;
    
    public OneAdressAssembly(Memory memory)
    {
        super(memory);
    }
    public void store(String adress)
    {
        this.memory.store(adress, accumulator);
    }
    public void load(String adress)
    {
        this.accumulator=this.memory.retrieve(adress);
    }
    public void add(String adress)
    {
        this.accumulator+=this.memory.retrieve(adress);
    }
    public void sub(String adress)
    {
        this.accumulator-=this.memory.retrieve(adress);
        
    }
    public void mpy(String adress)
    {
        this.accumulator*=this.memory.retrieve(adress);
        
    }
    public void div(String adress)
    {
        this.accumulator/=this.memory.retrieve(adress);
    }

}
