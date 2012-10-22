/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.sql.Timestamp;

/**
 *
 * @author Oswaldo
 */
public class BRuta {
    private int id;
    private Timestamp fecha;
    private BUsuario usuario_id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the usuario_id
     */
    public BUsuario getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(BUsuario usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
    
}
