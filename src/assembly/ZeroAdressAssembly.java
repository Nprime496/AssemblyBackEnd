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
public class ZeroAdressAssembly extends Assembly {

    private int currentIndex;
    private int stack[];
    public ZeroAdressAssembly(Memory memory)
    {
        super(memory);
        stack=new int[10];
        this.currentIndex=0;
    }
    public void push(String adress)
    {
        currentIndex++;
        stack[currentIndex]=memory.retrieve(adress);
    }
    public int pop(String adress)
    {
        currentIndex--;
        int value=stack[currentIndex+1];
        memory.store(adress,value);
        return value;
                ///(adress, stack[currentIndex]);
    }
    
    public void add() 
    {
        stack[currentIndex-1]+=stack[currentIndex];
        currentIndex--;
    }

    public void sub()
    {
        stack[currentIndex-1]-=stack[currentIndex];
        currentIndex--;
    }

    public void div()
    {
        stack[currentIndex-1]/=stack[currentIndex];
        currentIndex--;
    }

    public void mpy() {
        stack[currentIndex-1]*=stack[currentIndex];
        currentIndex--;
    }


}
