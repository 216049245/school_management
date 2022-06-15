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

//Need to sort out the build in the test case
    public static Student build(String s, String s1) {
        return  build(s, s1);
    }

    /*
    public static Student build(String s, String s1) {
        return build("test-id", "test-student");
    }
     */
}
