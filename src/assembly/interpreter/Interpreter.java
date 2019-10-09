/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.Assembly;
import static assembly.Command.*;
import assembly.AssemblyTwoAdress;

import assembly.AssemblyZeroAdress;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public abstract class Interpreter {
    protected InterpreterParser CommandParser;
    protected Assembly AssemblyMode;
    protected abstract void interpret(Instruction instruction);
    public void interpretBatch(ArrayList<Instruction> instruction)
    {
        for(Instruction i:instruction)
        {
            this.interpret(i);
        }
    }
    public void interpretLine(String instruction)
    {
        this.interpret(this.CommandParser.SplitInstruction(instruction));
    }
    public void interpretText(String text)
    {
        //on suppose qu'il y'a une instruction par ligne
        String[] lines=text.split("\n");
        for(String line:lines)
        {
            this.interpretLine(line);
        }
    }
    void branch(String adress)
    {
        //en cours...
    }
    
}
