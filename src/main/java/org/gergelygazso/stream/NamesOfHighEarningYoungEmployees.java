package org.gergelygazso.stream;

import java.util.ArrayList;
import java.util.List;

public class NamesOfHighEarningYoungEmployees {

    private static List<String> namesOfHighEarningYoungEmployees( List<Employee> list) {
        return list.stream().filter(e -> e.getSalary() > 50000).sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .map(Employee::getName).toList();
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 1, 60000, 30));
        employees.add(new Employee("Bob", 2, 48000, 45));
        employees.add(new Employee("Charlie", 1, 52000, 25));
        employees.add(new Employee("David", 3, 80000, 35));
        employees.add(new Employee("Eve", 2, 45000, 28));

//        Your task is to perform the following operations using Java streams:
//        Filter: Find all employees with a salary greater than $50,000.
//        Sort: Sort the filtered employees by their age in descending order.
//        Map: Create a list of the names of these sorted employees.

        System.out.println(namesOfHighEarningYoungEmployees(employees));

    }

    private static class Employee {
        private String name;
        private int deptId;
        private double salary;
        private int age;

        public Employee(String name, int deptId, double salary, int age) {
            this.name = name;
            this.deptId = deptId;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getDeptId() {
            return deptId;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }
    }
}
