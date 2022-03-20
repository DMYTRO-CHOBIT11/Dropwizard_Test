package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getAge() {
        return age;
    }
}
