/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.filemanager.Parser;
import static assembly.Command._ADD_;
import static assembly.Command._DIV_;
import static assembly.Command._MPY_;
import static assembly.Command._SUB_;
import assembly.AssemblyThreeAdress;
import assembly.AssemblyTwoAdress;
import assembly.memory.MyDesktop;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterThreeAdress extends Interpreter{
    private static int NB_OPERANDS=3;
    public InterpreterThreeAdress()
    {
        this.AssemblyMode=new AssemblyTwoAdress();
        this.CommandParser=new Parser(NB_OPERANDS);
    }
    @Override
    protected void interpretOperation(Instruction instruction)    
    {
        if(instruction instanceof InstructionOperation)
        {
            instruction=((InstructionOperation)instruction);
            if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_ADD_))
            {
                ((AssemblyThreeAdress)this.AssemblyMode).add(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1],((InstructionOperation)instruction).getOperands()[2]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_SUB_))
            {
                ((AssemblyThreeAdress)this.AssemblyMode).sub(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1],((InstructionOperation)instruction).getOperands()[2]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_DIV_))
            {
                ((AssemblyThreeAdress)this.AssemblyMode).div(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1],((InstructionOperation)instruction).getOperands()[2]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_MPY_))
            {
                ((AssemblyThreeAdress)this.AssemblyMode).mpy(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1],((InstructionOperation)instruction).getOperands()[2]);
            }
            else
            {
                System.out.println("operation non supportée");   
            }
            MyDesktop.getFlag().setValue((Integer)MyDesktop.getMemory().retrieve(((InstructionOperation)instruction).getOperands()[0]));
        }
    }

}
