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
public class ThreeAdressAssembly extends Assembly{
    public ThreeAdressAssembly(Memory memory)
    {
        super(memory);
    }
    public void add(String op1,String op2,String op3)
    {
        this.memory.store(op3,this.memory.retrieve(op1)+this.memory.retrieve(op2));
    }
    public void sub(String op1,String op2,String op3)
    {
        this.memory.store(op3,this.memory.retrieve(op1)-this.memory.retrieve(op2));
    }
    public void mpy(String op1,String op2,String op3)
    {
        this.memory.store(op3,this.memory.retrieve(op1)*this.memory.retrieve(op2));
    }
    public void div(String op1,String op2,String op3)
    {
        this.memory.store(op3,this.memory.retrieve(op1)/this.memory.retrieve(op2));
    }
}
