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
public class Mark {
    private int mid, markQuantity, regularMark1, regularMark2, regularMark3;
    private float examMark;
    private String studentCode, dcCode, subjectName;

    public Mark(int markQuantity, int regularMark1, int regularMark2, int regularMark3, float examMark, String studentCode, String dcCode, String subjectName) {
        this.markQuantity = markQuantity;
        this.regularMark1 = regularMark1;
        this.regularMark2 = regularMark2;
        this.regularMark3 = regularMark3;
        this.examMark = examMark;
        this.studentCode = studentCode;
        this.dcCode = dcCode;
        this.subjectName = subjectName;
    }

    public Mark(int mid, int markQuantity, int regularMark1, int regularMark2, int regularMark3, float examMark, String studentCode, String dcCode, String subjectName) {
        this.mid = mid;
        this.markQuantity = markQuantity;
        this.regularMark1 = regularMark1;
        this.regularMark2 = regularMark2;
        this.regularMark3 = regularMark3;
        this.examMark = examMark;
        this.studentCode = studentCode;
        this.dcCode = dcCode;
        this.subjectName = subjectName;
    }

    public int getMid() {
        return mid;
    }

    public int getMarkQuantity() {
        return markQuantity;
    }

    public int getRegularMark1() {
        return regularMark1;
    }

    public int getRegularMark2() {
        return regularMark2;
    }

    public int getRegularMark3() {
        return regularMark3;
    }

    public float getExamMark() {
        return examMark;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getDcCode() {
        return dcCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setMarkQuantity(int markQuantity) {
        this.markQuantity = markQuantity;
    }

    public void setRegularMark1(int regularMark1) {
        this.regularMark1 = regularMark1;
    }

    public void setRegularMark2(int regularMark2) {
        this.regularMark2 = regularMark2;
    }

    public void setRegularMark3(int regularMark3) {
        this.regularMark3 = regularMark3;
    }

    public void setExamMark(float examMark) {
        this.examMark = examMark;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setDcCode(String dcCode) {
        this.dcCode = dcCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public float getSumMark(){
        float sum = 0;
        float regMark = (regularMark1 + regularMark2 + regularMark3) / markQuantity;
        sum = (regMark + examMark * 2) / 3;
        return sum;
    }
    public boolean isPass(){
        return getSumMark() >= 4.0f;
    }
}
