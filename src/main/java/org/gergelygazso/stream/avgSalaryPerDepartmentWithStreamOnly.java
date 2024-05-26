package org.gergelygazso.stream;

import java.util.*;
import java.util.stream.Collectors;

public class avgSalaryPerDepartmentWithStreamOnly {

    private static Map<Integer, Integer> calculateAvgSalariesByDepartments(List<Person> personList) {
        Map<Integer, Double> collect = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getDeptId, // Group by department ID
                        Collectors.averagingInt(Person::getSalary) // Calculate average salary
                ));

        return collect.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
    }


    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 1, 50000));
        personList.add(new Person("Bob", 2, 55000));
        personList.add(new Person("Charlie", 1, 60000));
        personList.add(new Person("David", 3, 45000));
        personList.add(new Person("Eve", 2, 70000));
        personList.add(new Person("Frank", 3, 75000));
        personList.add(new Person("Grace", 1, 80000));
        personList.add(new Person("Hank", 2, 65000));
        personList.add(new Person("Ivy", 3, 62000));
        personList.add(new Person("Jack", 1, 58000));

        Map<Integer, Integer> avgSalariesByDepts = calculateAvgSalariesByDepartments(personList);
        System.out.println(avgSalariesByDepts);

    }

    private static class Person {

        private String name;
        private int deptId;
        private int salary;

        public Person(String name, int deptId, int salary) {
            this.name = name;
            this.deptId = deptId;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
    }
}
