package org.gergelygazso;

import java.util.*;
import java.util.stream.Collectors;

public class avgSalaryPerDepartmentWithHashMap {

    private static Map<Integer, Integer> calculateAvgSalariesByDepartments(List<Person> personList) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        personList.forEach(person -> {
                    List<Integer> deptAvgSalary = map.getOrDefault(person.deptId, Arrays.asList(0, 0));
                    deptAvgSalary.set(0, deptAvgSalary.get(0) + 1);
                    deptAvgSalary.set(1, deptAvgSalary.get(1) + person.getSalary());
                    map.put(person.deptId, deptAvgSalary);
                }
        );

        return map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().get(1) / entry.getValue().get(0)
        ));
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
