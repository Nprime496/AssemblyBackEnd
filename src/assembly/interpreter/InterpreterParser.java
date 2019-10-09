/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.interpreter.Instruction;
import assembly.interpreter.InstructionBranch;
import assembly.interpreter.InstructionOperation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author _Nprime496_
 */
public class InterpreterParser {
    private int nbParameters;//le nombre de paramètres de l'instruction qui est parsée
    public InterpreterParser(int nb)
    {
        this.nbParameters=nb;
    }
    public Pair<String,String> SplitAdress(String instruction)
    {
        //trouve la chaine avant ":" et enleve tous les espaces et retourne une paire où le premier élement est l'adresse
        int pos=instruction.indexOf(":");
        if (pos>-1)
            return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1).trim());
        return new Pair(null,instruction);
    }
    public Pair<String,String> SplitOperation(String instruction)
    {
        int pos=instruction.indexOf(" ");
        return new Pair(instruction.trim().substring(0,pos).trim(),instruction.substring(pos+1).trim());
        //trouve l'instruction à appeler      
    }
    public String[] SplitOperands(String instruction)
    {
        //chercher a appliquer trim sur chaque element du tableau
        //retourne une exception si le nombre d' operandes est superieur à this.nbParameters]
        return instruction.split(",");//supprime les espaces puis divise
    }
    public Pair<String,String> SplitBranch(String instruction)
    {
        int pos=instruction.trim().indexOf(" ");
        return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1));
    }
    
    public Instruction SplitInstruction(String instruction)
    {
        Pair<String,String> tmpPair=this.SplitAdress(instruction);
        String adress=tmpPair.getKey();

        try
        {
            tmpPair=this.SplitOperation(tmpPair.getValue());
            String[] operands=this.SplitOperands(tmpPair.getValue());
            return new InstructionOperation(adress,tmpPair.getKey(),operands);
        }
        catch(Exception notAnOperation)
        {
            try
            {
                tmpPair=this.SplitBranch(tmpPair.getValue());
                return new InstructionBranch(adress,tmpPair.getKey(),tmpPair.getValue());
                
            }
            catch(Exception neitherABranch)
            {
                neitherABranch.printStackTrace();
            }
            notAnOperation.printStackTrace();
        }

        return null;
    }
    
}
