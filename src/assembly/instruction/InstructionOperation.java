/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.instruction;

import assembly.instruction.Instruction;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author _Nprime496_
 */
public class InstructionOperation extends Instruction{
    private String operation;
    private String[] operands;

    public InstructionOperation(String adresse,String operation, String[] operands) {
        super(adresse);
        this.operation = operation;
        this.operands = operands;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String[] getOperands() {
        return operands;
    }

    public void setOperands(String[] operands) {
        this.operands = operands;
    }
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object autre)
    {
        if(!(autre instanceof InstructionOperation))
            return false;
        return (this.operation.equals(((InstructionOperation)autre).getOperation()) && Arrays.equals(this.operands,((InstructionOperation)autre).getOperands()));
    }
    @Override
    public String toString()
    {
        return this.adresse+'-'+this.operation+'-'+this.operands;
    }
}
