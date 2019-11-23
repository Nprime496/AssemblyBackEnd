/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionOperation;
import assembly.instruction.Instruction;
import assembly.AssemblyZeroAdress;
import assembly.memory.MyDesktop;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterZeroAdress extends Interpreter {
    public InterpreterZeroAdress()
    {
        this.AssemblyMode=new AssemblyZeroAdress();
    }
    /*@Override
    protected void interpretOperation(Instruction instruction)    
    {
        if(instruction instanceof InstructionOperation)
        {
            instruction=(InstructionOperation)instruction;
            if(((InstructionOperation)instruction).getOperation().equals(_ADD_))
            {
                ((AssemblyZeroAdress)this.AssemblyMode).add();
            }
            else if(((InstructionOperation)instruction).getOperation().equals(_SUB_))
            {
                ((AssemblyZeroAdress)this.AssemblyMode).sub();
            }
            else if(((InstructionOperation)instruction).getOperation().equals(_DIV_))
            {
                ((AssemblyZeroAdress)this.AssemblyMode).div();
            }
            else if(((InstructionOperation)instruction).getOperation().equals(_MPY_));
            {
                ((AssemblyZeroAdress)this.AssemblyMode).mpy();
            }
            MyDesktop.getFlag().setValue((Integer)MyDesktop.getStack().getHead());
        }
    }*/
    @Override
    public String toString()
    {
        return "Zero adress Assembly";
    }

    @Override
    public Boolean createFunctions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Boolean interpretOperation(Instruction instruction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
