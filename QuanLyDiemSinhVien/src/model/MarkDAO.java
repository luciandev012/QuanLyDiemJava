/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FirePhoenix
 */
public class MarkDAO {
    private DBConnection dbconn;
    private Connection conn;
    public MarkDAO(DBConnection dbconn){
        this.dbconn = dbconn;
        conn = this.dbconn.getConn();
    }

    public void addMark(Mark mark) {
        String sql = "insert into Mark values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, mark.getStudentCode());
            pre.setString(2, mark.getDcCode());
            pre.setString(3, mark.getSubjectName());
            pre.setInt(4, mark.getMarkQuantity());
            pre.setInt(5, mark.getRegularMark1());
            pre.setInt(6, mark.getRegularMark2());
            pre.setInt(7, mark.getRegularMark3());
            pre.setFloat(8, mark.getExamMark());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void deleteMark(String studentCode, String dcCode) {
        String sql = "delete Mark where studentCode=? and dcCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, studentCode);
            pre.setString(2, dcCode);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int updateMark(Mark mark) {
        String sql = "update Mark set markQuantity=?, regularMark1=?, regularMark2=?, regularMark3=?, examMark=? where studentCode=? and dcCode=?";
        int n = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mark.getMarkQuantity());
            pre.setInt(2, mark.getRegularMark1());
            pre.setInt(3, mark.getRegularMark2());
            pre.setInt(4, mark.getRegularMark3());
            pre.setFloat(5, mark.getExamMark());
            pre.setString(6, mark.getStudentCode());
            pre.setString(7, mark.getDcCode());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Mark> listAllMark(String subjectName) {
        String sql = "select * from Mark where subjectName=N'"+subjectName+"'";
        ArrayList<Mark> listMark = new ArrayList<>();
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                String studentCode = rs.getString(2);
                String dcCode = rs.getString(3);
                //String subjectName = rs.getString(4);
                int markQuantity = rs.getInt(5);
                int regularMark1 = rs.getInt(6);
                int regularMark2 = rs.getInt(7);
                int regularMark3 = rs.getInt(8);
                float examMark = rs.getFloat(9);
                Mark mark = new Mark(markQuantity, regularMark1, regularMark2, regularMark3, examMark, studentCode, dcCode, subjectName);
                listMark.add(mark);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMark;
    }

    public ArrayList<Mark> listMarkByStudentCode(String studentCode) {
        String sql = "select * from Mark where studentCode='"+studentCode+"'";
        ArrayList<Mark> li = new ArrayList<>();
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                //String studentCode = rs.getString(2);
                String dcCode = rs.getString(3);
                String subjectName = rs.getString(4);
                int markQuantity = rs.getInt(5);
                int regularMark1 = rs.getInt(6);
                int regularMark2 = rs.getInt(7);
                int regularMark3 = rs.getInt(8);
                float examMark = rs.getFloat(9);
                Mark mark = new Mark(markQuantity, regularMark1, regularMark2, regularMark3, examMark, studentCode, dcCode, subjectName);
                li.add(mark);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

    public ArrayList<Mark> listMarkByClass(String subjectName) {
        String sql = "select * from Mark where subjectName=N'"+subjectName+"'";
        ArrayList<Mark> li = new ArrayList<>();
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                String studentCode = rs.getString(2);
                String dcCode = rs.getString(3);
                //String subjectName = rs.getString(4);
                int markQuantity = rs.getInt(5);
                int regularMark1 = rs.getInt(6);
                int regularMark2 = rs.getInt(7);
                int regularMark3 = rs.getInt(8);
                float examMark = rs.getFloat(9);
                Mark mark = new Mark(markQuantity, regularMark1, regularMark2, regularMark3, examMark, studentCode, dcCode, subjectName);
                li.add(mark);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }
    
}
