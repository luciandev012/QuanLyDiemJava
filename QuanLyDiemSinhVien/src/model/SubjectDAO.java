/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Subject;
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
public class SubjectDAO {
    private DBConnection dbconn;
    private Connection conn;

    public SubjectDAO(DBConnection dbconn) {
        this.dbconn = dbconn;
        conn = this.dbconn.getConn();
    }
    public ArrayList<String> getSubjectCode(){
        ArrayList<String> subjectCode = new ArrayList<>();
        String sql = "select subjectCode from Subject";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                String sbCode = rs.getString(1);
                subjectCode.add(sbCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectCode;
    }
//    public ArrayList<Subject> listAllSubject(){
//        ArrayList<Subject> subject = new ArrayList<>();
//        String sql = "select * from Subject";
//        ResultSet rs = dbconn.getData(sql);
//        try {
//            while(rs.next()){
//                int suId = rs.getInt(1);
//                String subjectCode = rs.getString(2);
//                String subjectName = rs.getString(3);
//                int credits = rs.getInt(4);
//                Subject sbj = new Subject(subjectCode, subjectName, credits);
//                subject.add(sbj);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return subject;
//    }
    public ArrayList<Subject> listAllSubject(){
        ArrayList<Subject> subject = new ArrayList<>();
        String sql = "select * from Subject";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                int suId = rs.getInt(1);
                String subjectCode = rs.getString(2);
                String subjectName = rs.getString(3);
                int credits = rs.getInt(4);
                Subject sbj = new Subject(suId,subjectCode, subjectName, credits);
                subject.add(sbj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    public int addSubject(Subject su) {
        int n = 0;
        String sql = "insert into Subject values(?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, su.getSubjectCode());
            pre.setString(2, su.getSubjectName());
            pre.setInt(3, su.getCredits());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateSubject(Subject su) {
        int n = 0;
        String sql = "update Subject set subjectCode=?, subjectName=?, credits=? where suId=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, su.getSubjectCode());
            pre.setString(2, su.getSubjectName());
            pre.setInt(3, su.getCredits());
            pre.setInt(4, su.getSuId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteSubject(int suId) {
        int n = 0;
        String sql = "delete Subject where suId=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, suId);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Subject> listAllSubject(String sbjLookup) {
        ArrayList<Subject> subject = new ArrayList<>();
        String sql = "select * from Subject where subjectName like N'%"+sbjLookup+"%'";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                int suId = rs.getInt(1);
                String subjectCode = rs.getString(2);
                String subjectName = rs.getString(3);
                int credits = rs.getInt(4);
                Subject sbj = new Subject(suId,subjectCode, subjectName, credits);
                subject.add(sbj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    }

    public String getName(String subjectCode) {
        String sql = "select subjectName from Subject where subjectCode=N'"+subjectCode+"'";
        String subjectName = "";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                subjectName = rs.getString("subjectName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectName;
    }

    
}
