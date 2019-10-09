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
import assembly.AssemblyOneAdress;
import assembly.AssemblyThreeAdress;
import assembly.AssemblyTwoAdress;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterOneAdress extends Interpreter{
    private static int NB_OPERANDS=2;
    public InterpreterOneAdress()
    {
        this.AssemblyMode=new AssemblyOneAdress();
        this.CommandParser=new InterpreterParser(NB_OPERANDS);
    }
       @Override
    public void interpret(Instruction instruction)    
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
