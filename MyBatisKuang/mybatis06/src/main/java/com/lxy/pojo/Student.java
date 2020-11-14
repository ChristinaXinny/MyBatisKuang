package com.lxy.pojo;

/**
 * @author ChristinaXinny
 * @create 2020-11-11 2:55 下午
 */
public class Student {

    private int id;
    private String name;
    private Teacher tea;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", t=" + tea.toString() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getT() {
        return tea;
    }

    public void setT(Teacher t) {
        this.tea = t;
    }

    public Student(int id, String name, Teacher t) {
        this.id = id;
        this.name = name;
        this.tea = t;
    }
}
