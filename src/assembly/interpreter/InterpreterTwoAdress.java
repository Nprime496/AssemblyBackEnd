/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import static assembly.Command._ADD_;
import static assembly.Command._DIV_;
import static assembly.Command._MPY_;
import static assembly.Command._SUB_;
import assembly.AssemblyTwoAdress;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterTwoAdress extends Interpreter{
    private static int NB_OPERANDS=2;
    public InterpreterTwoAdress()
    {
        this.AssemblyMode=new AssemblyTwoAdress();
        this.CommandParser=new InterpreterParser(NB_OPERANDS);
    }
    @Override
    protected void interpret(Instruction instruction)    
    {
        if(instruction instanceof InstructionOperation)
        {
            instruction=((InstructionOperation)instruction);
            if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_ADD_))
            {
                ((AssemblyTwoAdress)this.AssemblyMode).add(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_SUB_))
            {
                ((AssemblyTwoAdress)this.AssemblyMode).sub(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_DIV_))
            {
                ((AssemblyTwoAdress)this.AssemblyMode).div(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);
            }
            else if(((InstructionOperation)instruction).getOperation().toUpperCase().equals(_MPY_))
            {
                ((AssemblyTwoAdress)this.AssemblyMode).mpy(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);
            }
            else
            {
                System.out.println("operation non supportée");   
            }
        }
    }

}
