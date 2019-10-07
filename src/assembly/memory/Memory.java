/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.memory;

import assembly.memory.IMemory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class Memory {//implements IMemory{
    private Map<String,Integer> memory;
    private int flag;

    public Map<String, Integer> getMemory() {
        return memory;
    }

    public void setMemory(Map<String, Integer> memory) {
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
        this.memory=new HashMap<String,Integer>();
        //System.out.println("MEMOIRE CRÉEE!!");
    }
    public void store(String adress,int value)
    {
        this.memory.put(adress,value);
    }

    public int retrieve(String adress)
    {
        //si l'adresse recherchée n'existe pas, une valeur aléatoire sera renvoyée
        int value;
        try
        {
            value= (int)this.memory.get(adress);
        }
        catch(NullPointerException e)
        {
            value=(int)(Math.random()*(Math.random()*100+Math.random()*50));
            this.memory.put(adress,value);
        }
        return value;
    }

}
