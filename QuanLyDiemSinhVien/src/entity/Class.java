/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author FirePhoenix
 */
public class Class {
    private int cid, course;
    private String classCode, className;

    public Class(int course, String classCode, String className) {
        this.course = course;
        this.classCode = classCode;
        this.className = className;
    }

    public Class(int cid, int course, String classCode, String className) {
        this.cid = cid;
        this.course = course;
        this.classCode = classCode;
        this.className = className;
    }
    
    public Class() {
    }

    public int getCid() {
        return cid;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
}
