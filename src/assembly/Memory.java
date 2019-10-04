/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class Memory implements IMemory{
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
    }
    @Override
    public void store(String adress,int value)
    {
        memory.put(adress,value);
    }
    @Override
    public int retrieve(String adress)
    {
        int value=(int)memory.get(adress);
        return value;
    }

}
