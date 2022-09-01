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
public class Subject {
    private int suId;
    private String subjectCode, subjectName;
    private int credits;

    public Subject(int suId, String subjectCode, String subjectName, int credits) {
        this.suId = suId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public Subject(String subjectCode, String subjectName, int credits) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSuId() {
        return suId;
    }
    
}
