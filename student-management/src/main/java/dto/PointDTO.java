package dto;

public class PointDTO {
    private String id;
    private String nameStudent;
    private String nameSubject;
    private float testMark;
    private float testMark15;
    private float testMark60;
    private float midterm;
    private float finalExam;
    private float avgPoint;

    public PointDTO() {
    }

    public PointDTO(String id, String nameStudent, String nameSubject, float testMark, float testMark15, float testMark60, float midterm, float finalExam, float avgPoint) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.nameSubject = nameSubject;
        this.testMark = testMark;
        this.testMark15 = testMark15;
        this.testMark60 = testMark60;
        this.midterm = midterm;
        this.finalExam = finalExam;
        this.avgPoint = avgPoint;
    }

    public PointDTO(String id, String nameStudent, String nameSubject, float testMark, float testMark15, float testMark60, float midterm, float finalExam) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.nameSubject = nameSubject;
        this.testMark = testMark;
        this.testMark15 = testMark15;
        this.testMark60 = testMark60;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
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

    public float getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(float avgPoint) {
        this.avgPoint = avgPoint;
    }
}