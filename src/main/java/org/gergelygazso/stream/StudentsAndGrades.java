package org.gergelygazso.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsAndGrades {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 10, List.of(85, 78, 90)));
        students.add(new Student("Bob", 9, List.of(88, 64, 70)));
        students.add(new Student("Charlie", 11, List.of(92, 83, 87)));
        students.add(new Student("David", 8, List.of(75, 80, 85)));
        students.add(new Student("Eve", 12, List.of(95, 91, 89)));
        students.add(new Student("Anna", 10, List.of(95, 91, 89)));

        // Task 1: Filter students in grade 10 and above
        List<Student> above10Grade = students.stream().filter(s -> s.getGradeLevel() >= 10).toList();
        System.out.println(above10Grade);
        System.out.println();

        // Task 2: Extract and flatten all scores into a single list of scores
        List<Integer> allScores = students.stream().flatMap(s -> s.getScores().stream()).toList();
        System.out.println(allScores);
        System.out.println();

        // Task 3: Filter scores to include only those greater than 75
        List<Integer> scoresAbove75 = allScores.stream().filter(s -> s > 75).toList();
        System.out.println(scoresAbove75);
        System.out.println();

        // Task 4: Group students by grade level and collect names into a map
        Map<Integer, List<String>> studentsByGradeLevel = students.stream().collect(Collectors.groupingBy(
                Student::getGradeLevel,
                Collectors.mapping(Student::getName, Collectors.toList())
        ));
        System.out.println(studentsByGradeLevel);


    }

    private static class Student {
        private String name;
        private int gradeLevel;
        private List<Integer> scores;

        public Student(String name, int gradeLevel, List<Integer> scores) {
            this.name = name;
            this.gradeLevel = gradeLevel;
            this.scores = scores;
        }

        public String getName() {
            return name;
        }

        public int getGradeLevel() {
            return gradeLevel;
        }

        public List<Integer> getScores() {
            return scores;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", gradeLevel=" + gradeLevel +
                    ", scores=" + scores +
                    '}';
        }
    }
}
