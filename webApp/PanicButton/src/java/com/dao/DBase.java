/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar A. Diaz
 */
public class DBase {

    protected String url;
    protected String usuario;
    protected String password;
    protected Connection conn;

    public DBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResourceBundle bundle = ResourceBundle.getBundle("com.dao.database");
        url = bundle.getString("url").trim();
        usuario = bundle.getString("usuario").trim();
        password = bundle.getString("password").trim();
    }

    protected void init_mysql() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            //MODIFICAR
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/panicbutton",
                    "root", "KIKKO");

        } catch (Exception e) {
            System.out.println("Fallo la conexion");
            e.printStackTrace();
        }

    }
}