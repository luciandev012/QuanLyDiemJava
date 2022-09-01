/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Class;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author FirePhoenix
 */
public class ClassDAO {

    private DBConnection dbconn;
    private Connection conn;

    public ClassDAO(DBConnection dbconn) {
        this.dbconn = dbconn;
        conn = dbconn.getConn();
    }

    public ArrayList<String> getClassCode() {
        ArrayList<String> listClassCode = new ArrayList<>();
        String sql = "select classCode from Class";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                String classCode = rs.getString(1);
                listClassCode.add(classCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClassCode;
    }

    public ArrayList<Class> listAllClass(String clsLookup) {
        ArrayList<Class> cls = new ArrayList<>();
        String sql = "select * from Class where className like N'%" + clsLookup + "%'";
        ResultSet rs = dbconn.getData(sql);
        try {
            while (rs.next()) {
                int cId = rs.getInt(1);
                String classCode = rs.getString(2);
                String className = rs.getString(3);
                int course = rs.getInt(4);
                Class cl = new Class(cId, course, classCode, className);
                cls.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cls;
    }

    public int addClass(Class cl) {
        int n = 0;
        String sql = "insert into Class values(?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cl.getClassCode());
            pre.setString(2, cl.getClassName());
            pre.setInt(3, cl.getCourse());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateClass(Class cl) {
        int n = 0;
        String sql = "update Class set classCode=?, className=?, course=? where cid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cl.getClassCode());
            pre.setString(2, cl.getClassName());
            pre.setInt(3, cl.getCourse());
            pre.setInt(4, cl.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteSubject(int cId) {
        int n = 0;
        String sql = "delete Class where cid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cId);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ResultSet listAllDynamicClass() {
        ResultSet rs = null;
        String sql = "select dcCode, Teacher.subjectCode, subjectName ,fullName, phoneNumber"
                + " from ((DynamicClass inner join Teacher on DynamicClass.teacherCode = Teacher.teacherCode)"
                + " inner join Subject on Teacher.subjectCode = Subject.subjectCode)";
        rs = dbconn.getData(sql);
        return rs;
    }

    public ResultSet listAllRealClass(String studentCode) {
        ResultSet rs = null;
        String sql = "select * from RealClass where studentCode='"+studentCode+"'";
        rs = dbconn.getData(sql);
        return rs;
    }

    public void addRealClass(String dcCode, String studentCode, String subjectName, String teacherName) {
        String sql = "insert into RealClass values(?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dcCode);
            pre.setString(2, studentCode);
            pre.setString(3, subjectName);
            pre.setString(4, teacherName);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void deleteRealClass(String dcCode, String studentCode) {
        String sql = "delete RealClass where dcCode=? and studentCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dcCode);
            pre.setString(2, studentCode);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getDcCodebySubName(String subName){
        String sql = "select dcCode from RealClass where subjectName=N'"+subName+"'";
        ResultSet rs = dbconn.getData(sql);
        String dcCode = "";
        try {
            while(rs.next()){
                dcCode = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dcCode;
    }
}
