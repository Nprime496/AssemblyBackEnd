/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.memory;


import assembly.instruction.Instruction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class Memory {//implements IMemory{
    private Map<String,Object> memory;
    private int flag;

    public Map<String, Object> getMemory() {
        return memory;
    }

    public void setMemory(Map<String, Object> memory) {
        this.memory = memory;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    public Memory()
    {
        this.memory=new HashMap<String,Object>();
        //System.out.println("MEMOIRE CRÉEE!!");
    }
    public void store(String adress,Object value)
    {
        if(value instanceof Instruction)
        {
            this.memory.put(adress, value);
            if(((Instruction) value).getAdresse()!=null)
                this.memory.put(((Instruction) value).getAdresse(),adress);
        }
        else
        {
           this.memory.put(adress,value); 
        }
        
    }

    public Object retrieve(String adress)
    {
        //si l'adresse recherchée n'existe pas, une valeur aléatoire sera renvoyée
        Object value;
        value= this.memory.get(adress);
        if(value==null)
        {
            value=(int)(Math.random()*(Math.random()*100+Math.random()*50));
            this.memory.put(adress,value);
        }
        return value;
    }
    public void clear()
    {
        this.memory=new HashMap<String,Object>();
    }

}
