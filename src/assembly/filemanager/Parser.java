/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.filemanager;

import assembly.instruction.*;
import javafx.util.Pair;
/**
 *
 * @author _Nprime496_
 */
public class Parser{
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
        //System.out.println(Commands.class.getFields());
        //faire une boucle pour verifier si le type des instructions
        Pair<String,String> tmpPair=this.SplitAdress(instruction);
        String adress=tmpPair.getKey();
        tmpPair=this.SplitBranch(tmpPair.getValue());
        for (CommandsBranch f : CommandsBranch.values())
        {
            if(f.toString().equals(tmpPair.getKey().toUpperCase()))
                return new InstructionBranch(adress,tmpPair.getKey(),tmpPair.getValue());
        }

        String temp=tmpPair.getKey()+" "+tmpPair.getValue();
        String[] tmp=temp.split(" ");
        for (CommandsSystem f : CommandsSystem.values())
        {
            if(f.toString().equals(tmp[0].toUpperCase()))
                return new InstructionDeclaration(adress,tmp[0],tmp[1],tmp[2]);
        }
        //est-il necessaire de verifier les operations, vu que les operations specifiques a un interpreteur
        //ne sont disponibles que dans l'interpreteur correspondant?
        tmpPair=this.SplitOperation(tmpPair.getKey()+" "+tmpPair.getValue());
        for (CommandsOperation f : CommandsOperation.values())
        {
            if(f.toString().equals(tmpPair.getKey().toUpperCase()))
            {         
                String[] timp=this.SplitOperands(tmpPair.getValue());
                return new InstructionOperation(adress,tmpPair.getKey(),timp);
            }
        }
        return null;
    }
}