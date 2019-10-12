/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionOperation;
import assembly.instruction.Instruction;
import assembly.filemanager.Parser;
import assembly.AssemblyOneAdress;
import assembly.AssemblyThreeAdress;
import assembly.AssemblyTwoAdress;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterOneAdress extends Interpreter{
    public InterpreterOneAdress()
    {
        this.AssemblyMode=new AssemblyOneAdress();
    }
    @Override
    protected void interpretOperation(Instruction instruction)    
    {
        if(instruction instanceof InstructionOperation)
        {
            instruction=((InstructionOperation)instruction);
            if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_ADD_))
            {
                ((AssemblyOneAdress)this.AssemblyMode).add(((InstructionOperation)instruction).getOperands()[0]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_SUB_))
            {
                ((AssemblyOneAdress)this.AssemblyMode).sub(((InstructionOperation)instruction).getOperands()[0]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_DIV_))
            {
                ((AssemblyOneAdress)this.AssemblyMode).div(((InstructionOperation)instruction).getOperands()[0]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_MPY_))
            {
                ((AssemblyOneAdress)this.AssemblyMode).mpy(((InstructionOperation)instruction).getOperands()[0]);
            }
            else
            {
                System.out.println("operation non supportée");   
            }
        }
    }


}
