package org.gergelygazso.stream;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsByCourse {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", List.of("Math", "Science", "English")));
        students.add(new Student("Bob", List.of("Math", "History", "Science")));
        students.add(new Student("Charlie", List.of("Math", "Art", "Physical Education")));
        students.add(new Student("David", List.of("History", "Science")));
        students.add(new Student("Eve", List.of("Art", "Math", "English")));

        // Task: Group students by courses they are enrolled in
        List<AbstractMap.SimpleEntry<String, String>> flatMap = students.stream().flatMap(student -> student.getCourses().stream()
                .map(course -> new AbstractMap.SimpleEntry<>(course, student.getName()))).toList();

        Map<String, List<String>> studentsByCourse = flatMap.stream().collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
        ));
        System.out.println(studentsByCourse);

    }

    private static class Student {
        private String name;
        private List<String> courses;

        public Student(String name, List<String> courses) {
            this.name = name;
            this.courses = courses;
        }

        public String getName() {
            return name;
        }

        public List<String> getCourses() {
            return courses;
        }
    }

}
