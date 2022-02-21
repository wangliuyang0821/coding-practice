package com.wly.beans;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/13
 * @备注:
 */
public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"salary\":")
                .append(salary);
        sb.append('}');
        return sb.toString();
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
