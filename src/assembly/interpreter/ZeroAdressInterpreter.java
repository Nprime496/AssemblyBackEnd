/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.interpreter;

import assembly.memory.Memory;
import assembly.ZeroAdressAssembly;
import assembly.parser.Parser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author _Nprime496_
 */
public class ZeroAdressInterpreter extends InterpreterWithOperands {
    private static int NB_OPERANDS=0;
    public ZeroAdressInterpreter()
    {
        this.AssemblyMode=new ZeroAdressAssembly();
        this.CommandParser=new Parser(NB_OPERANDS);
    }
    @Override
    public void interpretOperation(String[] operands)    
    {
        HashMap<String,Runnable> operations=new HashMap<String,Runnable>();
        operations.put("ADD",()->((ZeroAdressAssembly)this.AssemblyMode).add());
        operations.put("SUB",()->((ZeroAdressAssembly)this.AssemblyMode).sub());
        operations.put("DIV",()->((ZeroAdressAssembly)this.AssemblyMode).div());
        operations.put("MPY",()->((ZeroAdressAssembly)this.AssemblyMode).mpy());
    }

    @Override
    public void InterpretInstruction(Map instruction) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
