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
public class TwoAdressAssembly extends Assembly{

    public TwoAdressAssembly(Memory memory) {
        super(memory);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void add(String op1,String op2)
    {
        this.memory.store(op1,this.memory.retrieve(op1)+this.memory.retrieve(op2));
    }
    public void sub(String op1,String op2)
    {
        this.memory.store(op1,this.memory.retrieve(op1)-this.memory.retrieve(op2));
    }
    public void mpy(String op1,String op2)
    {
        this.memory.store(op1,this.memory.retrieve(op1)*this.memory.retrieve(op2));
    }
    public void div(String op1,String op2)
    {
        this.memory.store(op1,this.memory.retrieve(op1)/this.memory.retrieve(op2));
    }
    
}
