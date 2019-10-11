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
public class Stack {
    private static int currentIndex;
    private static int stack[];
    private static int TAILLE_MAX=10;
    public Stack()
    {
        stack=new int[TAILLE_MAX];
        this.currentIndex=0;
    }
    public void push(String adress)
    {
        currentIndex++;
        stack[currentIndex]=(Integer)MyDesktop.getMemory().retrieve(adress);
    }
    public int getHead()
    {
        return stack[currentIndex];
    }
    public int getSubHead()
    {
        if(currentIndex>0)
            return stack[currentIndex-1];
        return 0;
    }
    public void setSubHead(int value)
    {
        stack[currentIndex-1]=value;
    }
    public int pop(String adress) throws Exception
    {
        if(currentIndex>=0)
        {
            int value=stack[currentIndex];
            MyDesktop.getMemory().store(adress,value);
            currentIndex-=1; 
            return value;
        }
        else
        {
            throw new Exception("la pile est vide!!");
        }
                ///(adress, stack[currentIndex]);
    }
    public int pop() throws Exception
    {
        if(currentIndex>=0)
        {
            currentIndex-=1; 
            return stack[currentIndex+1];
        }
        else
        {
            throw new Exception("la pile est vide!!");
        }
                ///(adress, stack[currentIndex]);
    }

    private Exception Exception(String la_pile_est_vide) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
