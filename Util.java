package studentTask;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    //список уникальных курсов, на которые подписаны студенты
    public static List<Course> getListUniqueCourse(List<Student> studentList) {
        List<Course> courses = studentList
                .stream()
                .map(Student::getAllCourse)
                .flatMap(list -> list.stream())
                .collect(Collectors.toSet())
                .stream()
                .toList();
        return courses;

    }

    //список трех любознательных студентов(любознательность определяется количеством курсов)
    public static List<Student> getThreeInquisitiveStudent(List<Student> studentList) {
        List<Student> students = studentList
                .stream()
                .collect(Collectors.toMap(
                        student -> student,
                        student -> student.getAllCourse().size())
                )
                .entrySet()
                .stream()
                .sorted((val1, val2) -> Integer.compare(val2.getValue(), val1.getValue()))
                .limit(3)
                .map(el -> el.getKey())
                .toList();
        return students;
    }

    //список студентов, которые посещают указанный курс
    public static List<Student> getStudentCourse(List<Student> studentList, Course course) {
        List<Student> students = studentList
                .stream()
                .filter(student -> student.getAllCourse().contains(course))
                .toList();
        return students;
    }


}
