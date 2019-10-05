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
    //la plupart des methodes des classes "assembleur" seront statiques car l'entité
    //assembleur et ses opérations sont abstraites, cela n'a pas trop de sens
    //de créer un objet Assembleur
    public void setFlag(int result)
    {
        MyDesktop.getMemory().setFlag((result!=0)?(result/Math.abs(result)):0);
    }
}
