/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Chat;

import Bean.UsuarioLogueado;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Chat implements  Serializable{
    private UsuarioLogueado hoster;
    private ArrayList<UsuarioLogueado> usuarios = new ArrayList<>();
    private ArrayList<Mensaje> Mensajes = new ArrayList<Mensaje>();
    int id  ;
    private String Descripcion="descripcion";
    /***
     * @see  {genera un id aleatorio} 
     * @param Des  este parametro es la descripcion la q saldra cuando se muestre en la lista de chats disponibles
     */
    public Chat(String Des){
     id =(int)(Math.floor( Math.random()*1000000));
    Descripcion = Des;
    }

    public UsuarioLogueado getHoster() {
        return hoster;
    }

    public void setHoster(UsuarioLogueado hoster) {
        this.hoster = hoster;
    }

    public ArrayList<UsuarioLogueado> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioLogueado> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Mensaje> getMensajes() {
        return Mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> Mensajes) {
        this.Mensajes = Mensajes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }
    
}
