/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionOperation;
import assembly.instruction.Instruction;
import assembly.AssemblyTwoAdress;
import assembly.memory.MyDesktop;
import java.util.HashMap;
import java.util.function.Function;
import assembly.instruction.CommandsOperation;

/**
 *
 * @author _Nprime496_
 */

enum CommandsTwoAdresses
{
    STORE,
    LOAD;
}

public class InterpreterTwoAdress extends Interpreter{
    
    
    public InterpreterTwoAdress()
    {
        this.commandsDict=new HashMap();
        this.AssemblyMode=new AssemblyTwoAdress();
        createFunctions();
    }
    
    @Override
    public Boolean createFunctions()
    {
        System.out.println(this.toString()+": fonctions crées");
        //pour ajouter une nouvelle commande, il suffit de créer un nouvel objet Function et l'ajouter parmi les fonctionnalités de l'interpreteur avec un mot clé associé
        Function<Instruction,Boolean> add=(Instruction instruction)->{((AssemblyTwoAdress)this.AssemblyMode).add(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);return true;};
        commandsDict.put(CommandsOperation.ADD.toString(),add);
        Function<Instruction,Boolean> sub=(Instruction instruction)->{((AssemblyTwoAdress)this.AssemblyMode).sub(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);return true;};
        commandsDict.put(CommandsOperation.SUB.toString(),sub);
        Function<Instruction,Boolean> div=(Instruction instruction)->{((AssemblyTwoAdress)this.AssemblyMode).div(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);return true;};
        commandsDict.put(CommandsOperation.DIV.toString(),div);
        Function<Instruction,Boolean> mpy=(Instruction instruction)->{((AssemblyTwoAdress)this.AssemblyMode).mpy(((InstructionOperation)instruction).getOperands()[0],((InstructionOperation)instruction).getOperands()[1]);return true;};
        commandsDict.put(CommandsOperation.MPY.toString(),mpy);
        return true;
    }
    
    @Override
    public Boolean interpretOperation(Instruction instruction)
    {
        compute(commandsDict.get(((InstructionOperation)instruction).getOperation()),instruction);
        MyDesktop.getFlag().setValue((Integer)MyDesktop.getMemory().retrieve(((InstructionOperation)instruction).getOperands()[0]));
        return true;
    }
     
    @Override
    public String toString()
    {
        return "Two Adresses Assembly";
    }
}
