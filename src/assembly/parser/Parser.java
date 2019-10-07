/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author _Nprime496_
 */
public class Parser {
    private int nbParameters;//le nombre de paramètres de l'instruction qui est parsée
    public Parser(int nb)
    {
        this.nbParameters=nb;
    }
    public Pair<String,String> SplitAdress(String instruction)
    {
        //trouve la chaine avant ":" et enleve tous les espaces et retourne une paire où le premier élement est l'adresse
        int pos=instruction.indexOf(":");
        System.out.println("pos: "+pos);
        return new Pair(instruction.substring(0,pos),instruction.substring(pos+1));    
    }
    public Pair<String,String> SplitOperation(String instruction)
    {
        int pos=instruction.indexOf(" ");
        return new Pair(instruction.trim().substring(0,pos),instruction.substring(pos+1));
        //trouve l'instruction à appeler      
    }
    public String[] SplitOperands(String instruction)
    {
        //retourne une exception si le nombre d' operandes est superieur à this.nbParameters]
        return instruction.split(",");//supprime les espaces puis divise
    }
    public Pair<String,String> SplitBranch(String instruction)
    {
        int pos=instruction.trim().indexOf("");
        return new Pair(instruction.substring(0,pos),instruction.substring(pos+1));
    }
    
    public Map SplitInstruction(String instruction)
    {
        Pair<String,String> tmpPair=this.SplitAdress(instruction);
        String adress=tmpPair.getKey();
        if(adress!=null)
        {
            try
            {
                tmpPair=this.SplitOperation(tmpPair.getValue());
                String[] operands=this.SplitOperands(tmpPair.getValue());
            }
            catch(Exception notAnOperation)
            {
                try
                {
                    this.SplitBranch(tmpPair.getValue());
                }
                catch(Exception neitherABranch)
                {
                    neitherABranch.printStackTrace();
                }
                notAnOperation.printStackTrace();
            }
        }
        this.SplitInstruction(tmpPair.getKey());
        return null;
    }
    
}
