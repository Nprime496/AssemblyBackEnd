/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.filemanager;

import assembly.interpreter.Instruction;
import assembly.interpreter.InstructionBranch;
import assembly.memory.MyDesktop;

/**
 *
 * @author _Nprime496_
 */
public class FileManager {
    private Parser commandParser;

    public FileManager(Parser commandParser) {
        this.commandParser = commandParser;
    }
    
    public void loadInMemory(String text)
    {
        int i=0;
        String[] lines=text.split("\\r?\\n");
        for(String line:lines)
        {
            Instruction instr=this.commandParser.SplitInstruction(line);
            MyDesktop.getMemory().store(Integer.toString(i),instr);
            if(instr.getAdresse()!=null)
                MyDesktop.getMemory().store(instr.getAdresse(),i);
            i++;
        }
    }
}
