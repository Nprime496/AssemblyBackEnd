/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.filemanager.Parser;
import static assembly.Command.*;
import assembly.memory.Memory;
import assembly.AssemblyZeroAdress;
import assembly.memory.MyDesktop;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterZeroAdress extends Interpreter {
    private static int NB_OPERANDS=0;
    public InterpreterZeroAdress()
    {
        this.AssemblyMode=new AssemblyZeroAdress();
        this.CommandParser=new Parser(NB_OPERANDS);
    }
    @Override
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
    }


}
