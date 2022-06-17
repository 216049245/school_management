package factory;

import domain.Student;

public class StudentFactory {

    public static Student build(String studentId, String email, String name) {
        return new Student.Builder().studentId(studentId)
                .name(name)
                .email(email)
                .build();
    }
}
