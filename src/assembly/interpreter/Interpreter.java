/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.filemanager.Parser;
import assembly.Assembly;
import static assembly.Command.*;
import assembly.memory.MyDesktop;
import java.util.ArrayList;

/**
 *
 * @author _Nprime496_
 */
public abstract class Interpreter {
    
    //ce qui est important à retenir est que les instructions ayant une adresse seront stockées en deux temps d'abord dans leur ordre d'apparition
    //et ensuite leur numero de ligne sera conservé en mémoire dans une case ayant l'adresse mentionnée 
    //ainsi, un branchement vers cette case fournira le numéro de la ligne à executer et on se "branchera" à nouveau sur celle-ci
    protected Parser CommandParser;
    protected Assembly AssemblyMode;
    protected abstract void interpretOperation(Instruction instruction);
 
    public void interpretInstructions(ArrayList<Instruction> instruction)
    {
        for(Instruction i:instruction)
        {
            this.interpretOperation(i);
        }
    }
    public void interpretStringInstruction(String instruction)
    {
        //disponible uniquement pour les tests
        this.interpretOperation(this.CommandParser.SplitInstruction(instruction));
    }
    public void interpretTextInstructions(String text)
    {
        //utile uniquement pour les tests car viole le SINGLE RESPONSABILITY PRINCIPLE
        //on suppose qu'il y'a une instruction par ligne
        String[] lines=text.split("\\r?\\n");
        for(String line:lines)
        {
            this.interpretStringInstruction(line);
        }
            
    }
    public boolean interpretInstruction(Instruction instruction)
    {
        this.interpretOperation(instruction);
        boolean b=this.interpretBranch(instruction);//l'un au plus sera executé grace à la vérification des types dans les méthodes
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
        return b;
    }
    public boolean interpretBranch(Instruction instruction)
    {
        if(instruction instanceof InstructionBranch)
        {
            if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BR_))
            {
                MyDesktop.getCounter().setAdressNextInstruction((String)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BGT_) && MyDesktop.getFlag().getValue()==1 )
            {
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()))));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BLT_) && MyDesktop.getFlag().getValue()==-1 )
            {
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()))));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_BEZ_) && MyDesktop.getFlag().getValue()==0 )
            {
                MyDesktop.getCounter().setAdressNextInstruction((Integer.toString((Integer)MyDesktop.getMemory().retrieve(((InstructionBranch) instruction).getDestination()))));
            }
            else if(((InstructionBranch) instruction).getBranchement().toUpperCase().equals(_STOP_))
            {
                return false;
                //fin du programme
            }
            else
            {
                
                //on passe a l'instruction suivante
                MyDesktop.getCounter().setAdressNextInstruction(Integer.toString((Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())+1)));
            }
        }
        return true;
    }
    
    public void InterpretMemoryInstructions()
    {
        int i=0;
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString(i));
        boolean allIsFine=true;
        while(allIsFine)
        {
            allIsFine=this.interpretInstruction((Instruction)MyDesktop.getMemory().retrieve(Integer.toString(i)));
            i++;
            MyDesktop.getCounter().setAdressNextInstruction(Integer.toString(i));
        }
    }
    
}
