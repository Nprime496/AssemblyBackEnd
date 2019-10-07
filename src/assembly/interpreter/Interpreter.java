/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.Assembly;
import assembly.parser.Parser;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public abstract class Interpreter {
    protected Parser CommandParser;
    protected Assembly AssemblyMode;
    public abstract void InterpretInstruction(Map instruction);
    void branch(String adress)
    {
        
    }
}
