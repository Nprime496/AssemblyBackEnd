/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.instruction.InstructionBranch;
import assembly.instruction.InstructionDeclaration;
import assembly.instruction.Instruction;
import assembly.filemanager.Parser;
import assembly.Assembly;
import assembly.memory.MyDesktop;
import java.util.ArrayList;

/**
 *
 * @author _Nprime496_
 */
public abstract class Interpreter implements Commands {
    private static String buffer;
    //ce qui est important à retenir est que les instructions ayant une adresse seront stockées en deux temps d'abord dans leur ordre d'apparition
    //et ensuite leur numero de ligne sera conservé en mémoire dans une case ayant l'adresse mentionnée 
    //ainsi, un branchement vers cette case fournira le numéro de la ligne à executer et on se "branchera" à nouveau sur celle-ci
    //protected Parser CommandParser;
    protected Assembly AssemblyMode;

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer==null?"":buffer;
    }
    
    protected abstract void interpretOperation(Instruction instruction);
 
    public void interpretInstructions(ArrayList<Instruction> instruction)
    {
        for(Instruction i:instruction)
        {
            this.interpretOperation(i);
        }
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
        {
            //MyDesktop.getMemory().store(instruction.getAdresse(),);
            //System.out.println("une putain de declaration!!");
            //System.out.println("adresse:"+((InstructionDeclaration) instruction).getName()+"-valeur:"+Integer.parseInt(((InstructionDeclaration) instruction).getValue()));
            MyDesktop.getMemory().store(((InstructionDeclaration) instruction).getName().trim(),Integer.parseInt(((InstructionDeclaration) instruction).getValue()));
        }
    }
    public boolean interpretInstruction(Instruction instruction)
    {
        this.interpretOperation(instruction);
        boolean b=this.interpretBranch(instruction);//l'un au plus sera executé grace à la vérification des types dans les méthodes
        this.interpretDeclaration(instruction);
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
        return b;
    }
    public boolean interpretBranch(Instruction instruction)
    {
        if(instruction instanceof InstructionBranch)
        {
            System.out.println("flag: "+MyDesktop.getFlag().getValue());
            if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BR_))
            {
                //System.out.println(Integer.toString((int)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())));
                MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((int)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BGT_) && MyDesktop.getFlag().getValue()==1 )
            {
                System.out.println("BGT");
                //System.
                System.out.println("branchement : "+((InstructionBranch) instruction).getDestination()+", line : "+(Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()));
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BLT_) && MyDesktop.getFlag().getValue()==-1 )
            {
                System.out.println(((InstructionBranch) instruction).getDestination());
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BEZ_) && MyDesktop.getFlag().getValue()==0 )
            {
                System.out.println("BEZ");
                System.out.println("branchement : "+((InstructionBranch) instruction).getDestination()+", line : "+(Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()));
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination())-1)));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_PRINT_))
            {
                Object value=((InstructionBranch) instruction).getDestination();
                //System.out.println("valeur adresse: "+value);
                MyDesktop.print((String)value);
                //System.out.println(Integer.toString((Integer)MyDesktop.getMemory().retrieve((String)value)));
                //throw new PrintMessageException(Integer.toString((Integer)MyDesktop.getMemory().retrieve((String)value)));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_STOP_))
            {
                return false;
                //fin du programme
            }
            else
            {    
                //on passe a l'instruction suivante
                //System.out.println(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
                MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction()))));
            }
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
