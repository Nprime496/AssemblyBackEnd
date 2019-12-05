/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionBranch;
import assembly.instruction.InstructionDeclaration;
import assembly.instruction.Instruction;
import assembly.Assembly;
import assembly.instruction.CommandsBranch;
import assembly.instruction.InstructionOperation;
import assembly.memory.MyDesktop;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;


/**
 *
 * @author _Nprime496_
 */
public abstract class Interpreter{
    private static String buffer;
    //ce qui est important à retenir est que les instructions ayant une adresse seront stockées en deux temps d'abord dans leur ordre d'apparition
    //et ensuite leur numero de ligne sera conservé en mémoire dans une case ayant l'adresse mentionnée 
    //ainsi, un branchement vers cette case fournira le numéro de la ligne à executer et on se "branchera" à nouveau sur celle-ci
    protected Assembly AssemblyMode;
    protected static Map<String,Function<Instruction,Boolean>> commandsDict;

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer==null?"":buffer;
    }
    
    protected abstract Boolean interpretOperation(Instruction instruction);
    //public abstract Boolean computeInstruction(Instruction instruction);
    public abstract Boolean createFunctions();
    public void interpretInstructions(ArrayList<Instruction> instruction)
    {
        for(Instruction i:instruction)
        {
            this.interpretOperation(i);
        }
    }
    public Boolean compute(Function<Instruction, Boolean> function, Instruction instr) {
        return function.apply(instr);
    }

    /*public void interpretStringInstruction(String instruction)
    {
        //disponible uniquement pour les tests
        this.interpretOperation(this.CommandParser.SplitInstruction(instruction));
    }*/
    /*public void interpretTextInstructions(String text)
    {
        //utile uniquement pour les tests car viole le SINGLE RESPONSABILITY PRINCIPLE
        //on suppose qu'il y'a une instruction par ligne
        String[] lines=text.split("\\r?\\n");
        for(String line:lines)
        {
            this.interpretStringInstruction(line);
        }
            
    }*/
    public void interpretDeclaration(Instruction instruction)
    {
        if(instruction instanceof InstructionDeclaration) 
            MyDesktop.getMemory().store(((InstructionDeclaration) instruction).getName().trim(),Integer.parseInt(((InstructionDeclaration) instruction).getValue()));
    }
    
    public boolean interpretInstruction(Instruction instruction)
    {
        boolean b=true;
        System.out.println("interpreter "+instruction.getClass());
        if(instruction instanceof InstructionOperation)
        {
            System.out.println("interpret operation!");
            this.interpretOperation(instruction);
        }
        else if(instruction instanceof InstructionBranch)
        {
            System.out.println("interpret branch!");
            b=this.interpretBranch(instruction);//l'un au plus sera executé grace à la vérification des types dans les méthodes
        }
        else if (instruction instanceof InstructionDeclaration)
        {
            System.out.println("interpret declaration!");
            this.interpretDeclaration(instruction);
        }
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
        return b;
    }
    public boolean interpretBranch(Instruction instruction)
    {
        //code spaghetti à supprimer
        System.out.println("interpreting...");
        System.out.println("flag: "+MyDesktop.getFlag().getValue());
        if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.BR.toString()))
        {
            MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((int)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1));
        }
        else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.BGT.toString()) && MyDesktop.getFlag().getValue()==1 )
        {
            System.out.println("BGT");
            System.out.println("branchement : "+((InstructionBranch) instruction).getDestination()+", line : "+(Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()));
            MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
        }
        else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.BLT.toString()) && MyDesktop.getFlag().getValue()==-1 )
        {
            System.out.println(((InstructionBranch) instruction).getDestination());
            MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
        }
        else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.BEZ.toString()) && MyDesktop.getFlag().getValue()==0 )
        {
            System.out.println("BEZ");
            System.out.println("branchement : "+((InstructionBranch) instruction).getDestination()+", line : "+(Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()));
            MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
        }
        else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.PRINT.toString()))
        {
            String temp=((String)((InstructionBranch) instruction).getDestination());
            if(temp.trim().startsWith("\""))
            {
                MyDesktop.printMessage(temp.substring(1,temp.length()-1));
            }
            else
            {
                MyDesktop.print(temp);
            }
            //Object value=((InstructionBranch) instruction).getDestination();
            
        }
        else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(CommandsBranch.STOP.toString()))
        {
            return false;//fin du programme
        }
        else
        {    
            //on passe a l'instruction suivante
            //System.out.println(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
            MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction()))));
        }
        return true;
    }
    
    /*public void InterpretMemoryInstructions()
    {
        //int i=0;
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString(0));/
        boolean allIsFine=true;
        while(allIsFine)
        {
            //System.out.println(Integer.toString(Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())));
            allIsFine=this.interpretInstruction((Instruction)MyDesktop.getMemory().retrieve(Integer.toString(Integer.parseInt(MyDesktop.getCounter().getAdressInstruction()))));
            
            //MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
        }
    }*/
    
}
