package factory;

import domain.Student;

public class StudentFactory {

    public static Student createStudent( String studentId, String email, String name) {

        Student Student =  new Student.Builder().studentId(studentId)
                .name(name)
                .email(email)
                .build();
        return Student;
    }
}
