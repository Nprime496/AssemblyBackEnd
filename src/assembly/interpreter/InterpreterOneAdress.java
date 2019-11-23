/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionOperation;
import assembly.instruction.Instruction;
import assembly.AssemblyOneAdress;
import assembly.instruction.Commands;

/**
 *
 * @author _Nprime496_
 */

interface CommandsOneAdress extends Commands
{
        public String _PUSH_="PUSH";
        public String _POP_="POP";
}
public class InterpreterOneAdress extends Interpreter implements CommandsOneAdress{
    public InterpreterOneAdress()
    {
        this.AssemblyMode=new AssemblyOneAdress();
    }
    /*@Override
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
    }*/
    @Override
    public String toString()
    {
        return "One adress Assembly";
    }

    /*@Override
    public Boolean computeInstruction(Instruction instruction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public Boolean createFunctions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Boolean interpretOperation(Instruction instruction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
