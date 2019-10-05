/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembly;

import assembly.memory.MyDesktop;

/**
 *
 * @author _Nprime496_
 */
public class Assembly {

    public void setFlag(int result)
    {
        MyDesktop.getMemory().setFlag((result!=0)?(result/Math.abs(result)):0);
    }
}
