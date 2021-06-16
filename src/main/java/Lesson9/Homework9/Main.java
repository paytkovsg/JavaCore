package Lesson9.Homework9;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        // Создаем коллекцию студентов.
        List<Student> students = new ArrayList<Student>();
        // Наполняем коллекцию студентов и курсов
        for (int i = 1; i<11; i++) {
            Student student = new Student();
            student.setName("Студент " + i);
            // С ростом порядкового номера растет количество курсов у студента.
            for (int j = 1; j<=i; j++){
                for (int k = 0; k<j; k++){
                    Course course = new Course("Курс " + j);
                    student.setCourses(course); //добавляем студенту курсы
                }
            }
            //Добавляем студента c его курсами в список студентов.
            students.add(student);
        }

        //Выводим списки в консоль

        // Список уникальных курсов.
        System.out.println("Список уникальных курсов: ");
        List<String> uniqueCourses = uniqCoursesNames(students);
        uniqueCourses.stream()
                .forEach(System.out::println);

        // Список любознательных.
        System.out.println("Самые любознательные: ");
        inquisitive(students).stream()
                .sorted((stud0, stud1) -> stud1.getAllCourses().size() - stud0.getAllCourses().size())
                .map(inquisitive -> inquisitive.getName())
                .forEach(System.out::println);


        // Список студентов, посещающих определенный курс.
        Course course = new Course("Курс 7");
        System.out.printf("Студенты на курсе %s: \n", course.getName());
        attendingCourse(students, course).stream()
                .map(stud -> stud.getName())
                .forEach(System.out::println);
    }

    // Функция, принимающая список Student и возвращающая список уникальных курсов,
// на которые подписаны студенты.
    static List<String> uniqCoursesNames(List<Student> students) {
        List<String> uniqueCourses =
                students.stream()
                        .map(stu -> stu.getAllCourses())
                        .flatMap(Collection::stream)
                        .map(c -> c.getName())
                        .distinct()
                        .collect(Collectors.toList());


        return uniqueCourses;
    }

    // функция, принимающая на вход список Student и возвращающая список
    // из трех самых любознательных (любознательность определяется количеством курсов).
    static List<Student> inquisitive(List<Student> students) {
        List<Student> inquisitiveStudents =
                students.stream()
                        .sorted((stud0, stud1) -> stud1.getAllCourses().size() - stud0.getAllCourses().size())
                        .limit(3)
                        .collect(Collectors.toList());
        return inquisitiveStudents;
    }


    // Написать функцию, принимающую на вход список Student и экземпляр Course,
// возвращающую список студентов, которые посещают этот курс.
    static List<Student> attendingCourse(List<Student> students, Course course) {
        String courseName = course.getName();
        List<Student> studentsAttendingCourse =
                students.stream()
                        .filter(stud -> stud.getAllCourses().stream()
                                .filter(c -> c.getName().equals(courseName))
                                .count() > 0)
                        .collect(Collectors.toList());
        return studentsAttendingCourse;
    }
}
