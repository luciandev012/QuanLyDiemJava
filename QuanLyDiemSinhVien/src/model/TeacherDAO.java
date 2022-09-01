/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Teacher;
import java.sql.Connection;
import java.sql.Date;
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
public class TeacherDAO {
    private DBConnection dbconn;
    private Connection conn;
    public TeacherDAO(DBConnection dbconn){
        this.dbconn = dbconn;
        conn = dbconn.getConn();
    }
    public ArrayList<Teacher> listAllTeacher(String tcName){
        ArrayList<Teacher> listTc = new ArrayList<>();
        String sql = "select * from Teacher where fullName like N'%"+tcName+"%'";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                String teacherCode = rs.getString(2);
                String fullName = rs.getString(3);
                String subjectCode = rs.getString(4);
                String classCode = rs.getString(5);
                Date birthday = rs.getDate(6);
                boolean sex = rs.getBoolean(7);
                String email = rs.getString(8);
                String phoneNumber = rs.getString(9);
                Teacher tc = new Teacher(teacherCode, fullName, subjectCode, classCode, email, phoneNumber, birthday, sex);
                listTc.add(tc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTc;
    }
    public ArrayList<Teacher> listAllTeacher(String order, String criteria, String tcName){
        ArrayList<Teacher> listTc = new ArrayList<>();
        String sql = "select * from Teacher where fullName like N'%"+tcName+"%' order by "+order+" "+criteria+"";
        ResultSet rs = null;
        rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                String teacherCode = rs.getString(2);
                String fullName = rs.getString(3);
                String subjectCode = rs.getString(4);
                String classCode = rs.getString(5);
                Date birthday = rs.getDate(6);
                boolean sex = rs.getBoolean(7);
                String email = rs.getString(8);
                String phoneNumber = rs.getString(9);
                Teacher tc = new Teacher(teacherCode, fullName, subjectCode, classCode, email, phoneNumber, birthday, sex);
                listTc.add(tc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTc;
    }
    public int addTeacher(Teacher tc){
        int n = 0;
        String sql = "insert into Teacher values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,tc.getTeacherCode());
            pre.setString(2,tc.getFullName());
            pre.setString(3,tc.getSubjectCode());
            pre.setString(4,tc.getClassCode());
            pre.setDate(5, tc.getBirthday());
            pre.setBoolean(6,tc.isSex());
            pre.setString(7, tc.getEmail());
            pre.setString(8, tc.getPhoneNumber());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateTeacher(Teacher tc){
        int n = 0;
        String sql = "update Teacher set fullName=?, subjectCode=?, classCode=?, birthDay=?, sex=?, email=?, phoneNumber=? where teacherCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setString(1,tc.getTeacherCode());
            pre.setString(1,tc.getFullName());
            pre.setString(2,tc.getSubjectCode());
            pre.setString(3,tc.getClassCode());
            pre.setDate(4, tc.getBirthday());
            pre.setBoolean(5,tc.isSex());
            pre.setString(6, tc.getEmail());
            pre.setString(7, tc.getPhoneNumber());
            pre.setString(8, tc.getTeacherCode());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int deleteTeacher(String teacherCode){
        int n = 0;
        String sql = "delete Teacher where teacherCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, teacherCode);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public String getSubjectCode(String teacherName) {
        String sql = "select subjectCode from Teacher where fullName=N'"+teacherName+"'";
        String subjectCode = "";
        ResultSet rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                subjectCode = rs.getString("subjectCode");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjectCode;
    }

    public ArrayList<String> getTcCode() {
        String sql = "select teacherCode from Teacher";
        ResultSet rs = dbconn.getData(sql);
        ArrayList<String> li = new ArrayList<>();
        try {
            while(rs.next()){
                String tcCode = rs.getString("teacherCode");
                
                li.add(tcCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }
}
