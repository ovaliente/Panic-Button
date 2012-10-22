/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.util.Date;

/**
 *
 * @author Oswaldo
 */
public class BPosicion {
    private int id;
    private String longitud;
    private String latitud;
    private Date tiempo;
    private String rutahash;
    private int tipo_id;
    private int ruta_id;

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
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the tiempo
     */
    public Date getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the rutahash
     */
    public String getRutahash() {
        return rutahash;
    }

    /**
     * @param rutahash the rutahash to set
     */
    public void setRutahash(String rutahash) {
        this.rutahash = rutahash;
    }

    /**
     * @return the tipo_id
     */
    public int getTipo_id() {
        return tipo_id;
    }

    /**
     * @param tipo_id the tipo_id to set
     */
    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    /**
     * @return the ruta_id
     */
    public int getRuta_id() {
        return ruta_id;
    }

    /**
     * @param ruta_id the ruta_id to set
     */
    public void setRuta_id(int ruta_id) {
        this.ruta_id = ruta_id;
    }
    
}
