package com.practice.coding.common;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class JavaComparator {
    static Employee John = new Employee("John", 25, 3000.0, 9922001);
    static Employee Ace = new Employee("Ace", 22, 2000.0, 5924001);
    static Employee Keith = new Employee("Keith", 35, 4000.0, 3924401);

    static Employee[] employees = new Employee[] {John, Ace, Keith};
    static Employee[] sortedEmployeesByName = new Employee[] {Ace, John, Keith};
    static Employee[] sortedEmployeesByNameDesc = new Employee[] {Keith, John, Ace};
    static Employee[] sortedEmployeesByAge = new Employee[] {Ace, John, Keith};
    public static void main(String[] args) {

        Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
        Arrays.sort(employees, employeeNameComparator);
        System.out.println("Case 1: Sort By Name: "+Arrays.equals(employees, sortedEmployeesByName));

        employeeNameComparator = Comparator.comparing(
                Employee::getName, (s1, s2) -> {
                    return s2.compareTo(s1);
                });
        Arrays.sort(employees, employeeNameComparator);
        System.out.println("Case 1: Sort By Name DEsc: "+Arrays.equals(employees, sortedEmployeesByNameDesc));
    }
}

class Employee {
    String name;
    int age;
    double salary;
    long mobile;

    public Employee(String name, int age, double salary, long mobile) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mobile = mobile;
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

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
