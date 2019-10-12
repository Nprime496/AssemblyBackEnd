/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.instruction;

import assembly.instruction.Instruction;

/**
 *
 * @author _Nprime496_
 */
public class InstructionDeclaration extends Instruction{
    private String operation;
    private String name;
    private String value;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public InstructionDeclaration(String operation, String name, String value) {
        this.operation = operation;
        this.name = name;
        this.value = value;
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
