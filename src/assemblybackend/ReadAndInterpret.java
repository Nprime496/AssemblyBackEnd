/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import assembly.filemanager.FileManager;
import assembly.filemanager.Parser;
import assembly.interpreter.Interpreter;
import assembly.interpreter.InterpreterTwoAdress;

/**
 *
 * @author _Nprime496_
 */
public class ReadAndInterpret {
    private FileManager fileReader;
    private Interpreter interpreter;

    public ReadAndInterpret() {
        this.fileReader = new FileManager(new Parser()) ;
        this.interpreter = new InterpreterTwoAdress();
    }
    
    public void run(String instructions)
    {
        //String instruction=" sub A,B \n stop ";
        this.fileReader.loadInMemory(instructions);
        this.interpreter.InterpretMemoryInstructions();
    }
}
