package model;

public class Point {
    private String id_student;
    private int id_subject;
    private float testMark;
    private float testMark15;
    private float testMark60;
    private float midterm;
    private float finalExam;


    public Point() {
    }

    public Point(String id_student, int id_subject, float testMark, float testMark15, float testMark60, float midterm, float finalExam) {
        this.id_student = id_student;
        this.id_subject = id_subject;
        this.testMark = testMark;
        this.testMark15 = testMark15;
        this.testMark60 = testMark60;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public float getTestMark() {
        return testMark;
    }

    public void setTestMark(float testMark) {
        this.testMark = testMark;
    }

    public float getTestMark15() {
        return testMark15;
    }

    public void setTestMark15(float testMark15) {
        this.testMark15 = testMark15;
    }

    public float getTestMark60() {
        return testMark60;
    }

    public void setTestMark60(float testMark60) {
        this.testMark60 = testMark60;
    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(float finalExam) {
        this.finalExam = finalExam;
    }

}
