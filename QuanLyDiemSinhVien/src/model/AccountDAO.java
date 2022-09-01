/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FirePhoenix
 */
public class AccountDAO {
    private DBConnection dbconn;
    private Connection conn;
    public AccountDAO(DBConnection dbconn){
        this.dbconn = dbconn;
        conn = dbconn.getConn();
    }

    public Account login(String userName, String password) {
        String sql = "select * from Account where userName='"+userName+"' and password='"+password+"'";
        Account acc = null;
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                
                int aid = rs.getInt(1);
                String uName = rs.getString(2);
                String pass = rs.getString(3);
                String fullName = rs.getString(4);
                String position = rs.getString(5);
                acc = new Account(aid, uName, pass, fullName, position);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
    
}
