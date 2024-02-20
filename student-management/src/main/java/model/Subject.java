package model;

public class Subject {
    private int id;
    private String nameSubject;

    public Subject() {
    }

    public Subject(int id, String nameSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }
}
