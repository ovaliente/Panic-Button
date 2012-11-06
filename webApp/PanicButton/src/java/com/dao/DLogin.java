/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.BUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oswaldo
 */
public class DLogin extends DBase{
    
    public BUsuario ValidarUsuario(String user, String pass) {
        BUsuario buser = null;

        this.init_mysql();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            
            String query = "SELECT u.id, u.username,u.password, u.email, u.admin FROM usuario u "
                    + "WHERE u.username='" + user + "'"
                    + " AND u.password='"+pass+"'";
            pstmt = conn.prepareStatement(query);
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                buser = new BUsuario();
                buser.setId(rs.getInt(1));
                buser.setUsername(rs.getString(2));
                buser.setPassword(rs.getString(3));
                buser.setEmail(rs.getString(4));
                buser.setAdmin(rs.getInt(5));
               
            }
            
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
             System.err.println("Error al ejecutar el query");
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ;
                }
                rs = null;
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    ;
                }
                pstmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ;
                }
                conn = null;
            }
        }
        return buser;

    }
    
}
