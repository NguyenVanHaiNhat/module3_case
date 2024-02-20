package model;

public class Class {
    private int id;
    private String nameClass;

    public Class(){}
    public Class(int id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
