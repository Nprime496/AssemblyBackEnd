/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.filemanager;

import assembly.instruction.*;
import java.lang.reflect.Field;
import javafx.util.Pair;

/**
 *
 * @author _Nprime496_
 */
public class Parser implements Commands{
    public Pair<String,String> SplitAdress(String instruction)
    {
        //separe l'adresse de l'instruction du contenu
        //trouve la chaine avant ":" et enleve tous les espaces et retourne une paire où le premier élement est l'adresse
        int pos=instruction.indexOf(":");
        if (pos>-1)
            return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1).trim());
        return new Pair(null,instruction.trim());
    }

    public Pair<String,String> SplitDeclarationAttributes(String instruction)
    {
        int pos=instruction.indexOf(" ");
        return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1).trim());
    }
    public Pair<String,String> SplitOperation(String instruction)
    {
        //separe l'operation des operandes
        int pos=instruction.indexOf(" ");
        return new Pair(instruction.trim().substring(0,pos).trim(),instruction.substring(pos+1).trim());
        //trouve l'instruction à appeler      
    }
    public String[] SplitOperands(String instruction)
    {
        //separe les operandes
        //chercher a appliquer trim sur chaque element du tableau
        //retourne une exception si le nombre d' operandes est superieur à this.nbParameters]
        String[] l=instruction.split(",");//supprime les espaces puis divise
        for(int i=0;i<l.length;i++)
            l[i]=l[i].trim();
        return l;
    }
    public Pair<String,String> SplitBranch(String instruction)
    {
        //separe le type de branchement de l'adresse
        int pos=instruction.trim().indexOf(" ");
        if(pos<instruction.length() && pos>-1)
            return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1));
        return new Pair(instruction,null);//cas particulier de STOP
    }
    public Pair<String,String> SplitCommentary(String instruction)
    {
        //enlève les commentaires
        int pos=instruction.trim().indexOf("//");
        return new Pair(instruction.substring(0,pos).trim(),instruction.substring(pos+1));
    }
    public Instruction SplitInstruction(String instruction)
    {
        //crée une instruction
        System.out.println(Commands.class.getFields());
        //faire une boucle pour verifier si le type des instructions

        Pair<String,String> tmpPair=this.SplitAdress(instruction);
        String adress=tmpPair.getKey();
        System.err.println(instruction);
        for (Field f : CommandsBranch.class.getFields())
        {
            if(f.equals(tmpPair.getValue().toUpperCase()))
            {
                System.err.println("branch!!");
                tmpPair=this.SplitBranch(tmpPair.getValue());
                return new InstructionBranch(adress,tmpPair.getKey(),tmpPair.getValue());
            }
        }
        for (Field f : CommandsOperation.class.getFields())
        {
            if(f.equals(tmpPair.getValue().toUpperCase()))
            {
                System.err.println("operation!!");
                System.out.println("operation!!!");
                tmpPair=this.SplitOperation(tmpPair.getValue());
                String[] tmp=this.SplitOperands(tmpPair.getValue());
                return new InstructionOperation(adress,tmpPair.getKey(),tmp);
            }
        }
        return null;
        /*
        if(tmpPair.getValue().trim().charAt(0)=='B' || tmpPair.getValue().trim().toUpperCase().equals("STOP") || tmpPair.getValue().trim().toUpperCase().contains("PRINT"))
        {
            System.out.println("branch!!");
            tmpPair=this.SplitBranch(tmpPair.getValue());
            return new InstructionBranch(adress,tmpPair.getKey(),tmpPair.getValue());
        }
        else if(tmpPair.getValue().trim().startsWith("SET"))
        {
            System.out.println("declaration!!");
            //int pos=tmpPair.getValue().indexOf(" ");
            String[] tmp=tmpPair.getValue().split(" ");
            return new InstructionDeclaration(adress,tmp[0],tmp[1],tmp[2]);
        }
        else
        {
            System.out.println("operation!!!");
            tmpPair=this.SplitOperation(tmpPair.getValue());
            String[] tmp=this.SplitOperands(tmpPair.getValue());
            return new InstructionOperation(adress,tmpPair.getKey(),tmp);
        }*/
        //return null;
    }
    
}
