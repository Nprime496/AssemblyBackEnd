package assembly.instruction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author _Nprime496_
 */

interface CommmandsSystem
{
    //commandes de communication avec le systeme
    final String _SET_="SET";//permet d'initialiser des valeurs
    final String _PRINT_="PRINT";
}

public interface Commands extends CommandsBranch,CommandsOperation,CommmandsSystem
{
    //all the basic commands here by heritage
}