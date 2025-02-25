package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Employee {
    long id;
    int salary;
    String firstName;
    String lastName;
    String designation;


    public Employee(long id, int salary, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public static void main(String[] s){
        List<Employee> employeeList = new ArrayList<Employee>();
        Random r = new Random();
        long id = 100;
        employeeList.add(new Employee(id++,2000,"FirstName"+r.nextInt(),"Lastname"+r.nextInt()));
        for(int i=0;i<100;i++){
            employeeList.add(new Employee(id++,r.nextInt()*1000,"FirstName"+r.nextInt(),"Lastname"+r.nextInt()));
        }

        List<Employee> filteredEmp = employeeList.stream().filter(emp->emp.getSalary()== 2000).collect(Collectors.toList());
        filteredEmp.stream().forEach(emp->{
            System.out.println("Employee id:"+emp.getId()+" Salary:"+emp.getSalary());
        });

        Optional<Employee> distincEmployee = employeeList.stream().filter(emp->emp.getId()== 101l).findFirst();

            System.out.println("Distinct Employee id:"+Optional.of(distincEmployee).get().toString());

    }

}
