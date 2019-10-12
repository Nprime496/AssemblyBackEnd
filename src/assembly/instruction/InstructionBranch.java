/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.instruction;

import assembly.instruction.Instruction;
import java.util.Objects;

/**
 *
 * @author _Nprime496_
 */
public class InstructionBranch extends Instruction{
    private String branchement;
    private String destination;

    public InstructionBranch(String adresse,String branchement, String destination) {
        this.branchement = branchement;
        this.destination = destination;
        this.adresse=adresse;
    }
    
    

    public String getBranchement() {
        return branchement;
    }

    public void setBranchement(String branchement) {
        this.branchement = branchement;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object autre)
    {
        if(!(autre instanceof InstructionBranch))
            return false;
        return (this.branchement.equals(((InstructionBranch)autre).getBranchement()) && this.destination.equals(((InstructionBranch)autre).destination));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.branchement);
        hash = 31 * hash + Objects.hashCode(this.destination);
        return hash;
    }
}
