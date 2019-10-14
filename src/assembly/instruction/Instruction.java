/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.instruction;

/**
 *
 * @author _Nprime496_
 */
public abstract class Instruction {
    protected String adresse;

    public Instruction(String adresse) {
        this.adresse = adresse;
    }
    
    public abstract void execute();

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
