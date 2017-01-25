package com.qule.example.model;

/**
 * @author qule
 * @version V1.0.0
 * @Description 学生实体类
 * @date 2017-01-25 23:10
 */
public class Student {
    String name;
    int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int hashCode() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return this.name.equals(student.name)&&this.score==student.score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
