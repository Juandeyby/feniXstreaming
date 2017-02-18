package Ruteador.Bean;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class dota  implements  Serializable{
    public String [] ip={"2","3","5","6"};

    @Override
    public String toString() {
        return "dota{" + "ip=" + ip + '}';
    }

}
