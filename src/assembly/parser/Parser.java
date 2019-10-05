/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.parser;

import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class Parser {
    public String SplitAdress(String instruction)
    {
        //trouve la chaine avant ":" et enleve tous les espaces
        return instruction.substring(0,instruction.indexOf(":")).replaceAll("\\s","");     
    }
    public String SplitOperation(String instruction)
    {
        String operation=instruction.trim().substring(0,instruction.indexOf(" ")).toUpperCase();
        return operation;
        //trouve l'instruction à appeler      
    }
    public String[] SplitOperands(String instruction,int nbParameters)
    {
        String []operands=new String[nbParameters];
        for(int i=0;i<nbParameters;i++)
        {
            int pos=instruction.indexOf(",");
            operands[i]=instruction.trim().substring(0,pos).trim().toUpperCase();
            instruction=instruction.substring(pos+1,instruction.length()).toUpperCase();
        }
        /*
        if(instruction.length()>0)
            return uneExeption
        */
        return operands;
    }
    public String SplitBranchement(String instruction)
    {
        int pos=instruction.trim().indexOf(" ");
        String branchement=instruction.substring(pos);
        
        return branchement; 
    }
    public String SplitBranch(String instruction)
    {
        String branch=instruction.trim().substring(instruction.indexOf(" "));
        return branch;
    }
    
    public Map SplitInstruction(String instruction,int nbParameters)
    {
        String adress=this.SplitAdress(instruction.trim());
        String operation=this.SplitOperation(instruction.substring(adress.length()));
        String[] operands=this.SplitOperands(instruction.substring(operation.length()),nbParameters);
        
        return null;
    }
    
}
