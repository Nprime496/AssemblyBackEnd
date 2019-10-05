/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import java.util.HashMap;
import java.util.Map;
import assembly.Assembly;
import assembly.memory.Memory;
/**
 *
 * @author _Nprime496_
 */
public abstract class InterpreterWithOperands extends Interpreter {
    
    
    public abstract void interpretOperation(String[] operands);

}
