/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly.memory;

/**
 *
 * @author _Nprime496_
 */
public interface IMemory {

    /**
     *
     * @param adress
     * @param value
     */
    public void store(String adress,int value);
    public int retrieve(String adress);
}
