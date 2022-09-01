/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FirePhoenix
 */
public class StudentDAO {
    private DBConnection dbconn;
    private Connection conn;
    public StudentDAO(DBConnection dbconn){
        this.dbconn = dbconn;
        conn = dbconn.getConn();
    }
    public ArrayList<Student> listAllStudent(String stName){
        ArrayList<Student> listSt = new ArrayList<>();
        String sql = "select * from Student where fullName like N'%"+stName+"%'";
        ResultSet rs = null;
        rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                int sid = rs.getInt(1);
                String studentCode = rs.getString(2);
                String fullName = rs.getString(3);
                String classCode = rs.getString(4);
                String eduSystem = rs.getString(5);
                Date birthday = rs.getDate(6);
                String address = rs.getString(7);
                boolean sex = rs.getBoolean(8);
                String phoneNumber = rs.getString(9);
                Student st = new Student(sid, studentCode, fullName, classCode, eduSystem, address, phoneNumber, sex, birthday);
                listSt.add(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSt;
    }
    public ArrayList<Student> listAllStudent(String order, String criteria, String stName){
        ArrayList<Student> listSt = new ArrayList<>();
        String sql = "select * from Student where fullName like N'%"+stName+"%' order by "+order+" "+criteria+"";
        ResultSet rs = null;
        rs = dbconn.getData(sql);
        try {
            while(rs.next()){
                int sid = rs.getInt(1);
                String studentCode = rs.getString(2);
                String fullName = rs.getString(3);
                String classCode = rs.getString(4);
                String eduSystem = rs.getString(5);
                Date birthday = rs.getDate(6);
                String address = rs.getString(7);
                boolean sex = rs.getBoolean(8);
                String phoneNumber = rs.getString(9);
                Student st = new Student(sid, studentCode, fullName, classCode, eduSystem, address, phoneNumber, sex, birthday);
                listSt.add(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSt;
    }
    public int addStudent(Student st){
        int n = 0;
        String sql = "insert into Student values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,st.getStudentCode());
            pre.setString(2,st.getFullName());
            pre.setString(3,st.getClassCode());
            pre.setString(4,st.getEduSystem());
            pre.setDate(5, st.getBirthday());
            pre.setString(6,st.getAddress());
            pre.setBoolean(7, st.isSex());
            pre.setString(8, st.getPhoneNumber());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateStudent(Student st){
        int n = 0;
        String sql = "update Student set fullName=?, classCode=?, eduSystem=?, birthday=?, address=?, sex=?, phoneNumber=? where studentCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,st.getFullName());
            pre.setString(2,st.getClassCode());
            pre.setString(3,st.getEduSystem());
            pre.setDate(4, st.getBirthday());
            pre.setString(5,st.getAddress());
            pre.setBoolean(6, st.isSex());
            pre.setString(7, st.getPhoneNumber());
            pre.setString(8,st.getStudentCode());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int deleteStudent(String studentCode){
        int n = 0;
        String sql = "delete Student where studentCode=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,studentCode);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public String getStudentName(String studentCode) {
        String sql = "select fullName from Student where studentCode='"+studentCode+"'";
        ResultSet rs = dbconn.getData(sql);
        String studentName = "";
        try {
            while(rs.next()){
                studentName = rs.getString("fullName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentName;
    }

    public ArrayList<String> getStCode() {
        String sql = "select studentCode from Student";
        ResultSet rs = dbconn.getData(sql);
        ArrayList<String> li = new ArrayList<>();
        try {
            while(rs.next()){
                String stCode = rs.getString("studentCode");
                
                li.add(stCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }
}
