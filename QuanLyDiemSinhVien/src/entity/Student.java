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
public class Student {
    private int sid;
    private String studentCode, fullName, classCode, eduSystem, address, phoneNumber;
    private boolean sex;
    private Date birthday;

    public Student() {
    }

    public Student(int sid, String studentCode, String fullName, String classCode, String eduSystem, String address, String phoneNumber, boolean sex, Date birthday) {
        this.sid = sid;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.classCode = classCode;
        this.eduSystem = eduSystem;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Student(String studentCode, String fullName, String classCode, String eduSystem, String address, String phoneNumber, boolean sex, Date birthday) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.classCode = classCode;
        this.eduSystem = eduSystem;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthday = birthday;
    }
    public int getSId(){
        return sid;
    }
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getEduSystem() {
        return eduSystem;
    }

    public void setEduSystem(String eduSystem) {
        this.eduSystem = eduSystem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", studentCode=" + studentCode + ", fullName=" + fullName + ", classCode=" + classCode + ", eduSystem=" + eduSystem + ", address=" + address + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", birthday=" + birthday + '}';
    }
    
}
