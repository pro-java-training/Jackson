package com.codve.JsonTest;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private double salary;

    // json 字符串转换为Java 对象时，一定要一个无参构造函数
    public Person() {

    }

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    protected String info() {
        return "name: " + this.name + ", age: " + this.age + ", salary: " + this.salary;
    }
}
