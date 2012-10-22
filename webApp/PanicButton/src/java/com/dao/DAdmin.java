/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.BUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oswaldo
 */
public class DAdmin extends DBase {
    
    public ArrayList<BUsuario> ListarUsuario() {

        BUsuario buser = null;
        ArrayList<BUsuario> L = new ArrayList<BUsuario>();

        this.init_mysql();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT u.id,u.username,u.password,u.userhash, u.email FROM usuario u";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                buser = new BUsuario();
                buser.setId(rs.getInt(1));
                buser.setUsername(rs.getString(2));
                buser.setPassword(rs.getString(3));
                buser.setUserhash(rs.getString(4));
                buser.setEmail(rs.getString(5));
              

                L.add(buser);
            }



            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
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
        return L;

    }
    
    
    
    
     public BUsuario DataUsuario(int iduser) {
        BUsuario buser = null;


        this.init_mysql();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT u.id,u.username,u.password,u.userhash,u.email"
                    + " FROM usuario u where u.id=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, iduser);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                buser = new BUsuario();
                buser.setId(rs.getInt(1));
                buser.setUsername(rs.getString(2));
                buser.setPassword(rs.getString(3));
                buser.setUserhash(rs.getString(4));
                //buser.setContrasena(rs.getString(5));
                buser.setEmail(rs.getString(5));
               


            }



            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
     
      public void borrado(int iduser){
    
        this.init_mysql();
        PreparedStatement pstmt = null;
        try {
             String query = "update usuario set borrado='0' where idusuario = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, iduser);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
    }
    
      public void GuardaUsuario(BUsuario buser) {

        this.init_mysql();
        PreparedStatement pstmt = null;
        try {

            String query = "UPDATE usuario u SET u.username = ?, u.apassword = ?, u.email = ? "
                    + " WHERE u.idusuario = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, buser.getUsername());
            pstmt.setString(2, buser.getPassword());
            pstmt.setString(3, buser.getEmail());
            
           
           
            pstmt.setInt(4, buser.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    }
}
