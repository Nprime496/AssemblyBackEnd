/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

/**
 *
 * @author _Nprime496_
 */
class Assembly {
    protected Memory memory;
    public Assembly(Memory memory)
    {
        this.memory=memory;
    }
    public void print(String adress) {
        System.out.println(memory.retrieve(adress));
    }
    public void setFlag(int result)
    {
        this.memory.setFlag((result!=0)?(result/Math.abs(result)):0);
    }
}
