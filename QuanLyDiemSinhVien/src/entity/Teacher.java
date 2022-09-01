/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author FirePhoenix
 */
public class Teacher {
    private int tid;
    private String teacherCode, fullName, subjectCode, classCode, email, phoneNumber;
    private Date birthday;
    private boolean sex;
    
    public Teacher(){
        
    }

    public Teacher(String teacherCode, String fullName, String subjectCode, String classCode, String email, String phoneNumber, Date birthday, boolean sex) {
        this.teacherCode = teacherCode;
        this.fullName = fullName;
        this.subjectCode = subjectCode;
        this.classCode = classCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getTid() {
        return tid;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
}
