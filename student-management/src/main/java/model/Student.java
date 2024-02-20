package model;

public class Student extends Class {
    private String id;
    private String nameStudent;
    private String dayOfBirth;
    private String address;
    private int id_class;

    public Student() {
    }

    public Student(String id, String nameStudent, String dayOfBirth, String address, int id_class) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.id_class = id_class;
    }
    public Student(String id, String nameStudent, String dayOfBirth, String address, String nameClass) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.setNameClass(nameClass);
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }
}
