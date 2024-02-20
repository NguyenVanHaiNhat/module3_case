package model;

public class Class {
    private int idClass;
    private String nameClass;

    public Class(){}
    public Class(int id, String nameClass) {
        this.idClass = id;
        this.nameClass = nameClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void setId(int id) {
        this.idClass = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
