/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.BRuta;
import com.bean.BUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oswaldo
 */
public class DRuta extends DBase {
    
    public ArrayList<BRuta> ListarRuta(int idusuario) {

        BRuta bruta = null;
        BUsuario busuario=null;
        ArrayList<BRuta> L = new ArrayList<BRuta>();

        this.init_mysql();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT r.id,r.fecha,r.usuario_id FROM ruta r where usuario_id like '"+idusuario+"'";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                bruta = new BRuta();
                busuario= new BUsuario();
                busuario.setId(idusuario);
                bruta.setId(rs.getInt(1));
                bruta.setFecha(rs.getTimestamp(2));
                
                bruta.setUsuario_id(busuario);
                
              

                L.add(bruta);
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
    
}
