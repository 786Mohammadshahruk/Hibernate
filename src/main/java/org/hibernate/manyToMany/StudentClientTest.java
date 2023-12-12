package org.hibernate.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentClientTest {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    private static void addStudent(Student student) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private static void getStudent(int studentId) {

        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, studentId);

            System.out.println("STUDENT : " + student);
            //System.out.println("COURSE : " + student.getCoursesList());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    public static void main(String[] args) {
        List<Student> studentList = getStudentList();
        List<Course> courseList = getCourseList();

        /*courseList.get(0).setStudentList(studentList);
        courseList.get(1).setStudentList(studentList);
        courseList.get(2).setStudentList(studentList);*/

        studentList.get(0).setCoursesList(courseList);
        studentList.get(1).setCoursesList(courseList);
        studentList.get(2).setCoursesList(courseList);


        //addStudent(studentList.get(2));


        //studentList.stream().forEach(i -> addStudent(i));

        //studentList.stream().forEach(StudentClientTest::addStudent);

        /*for (Student student:studentList) {
            addStudent(student);
        }

        for(int i = 0;i<studentList.size();i++){
            addStudent(studentList.get(i));
        }*/


        getStudent(1);


    }

    private static List<Student> getStudentList() {
        Student student1 = new Student();
        student1.setStudentName("Aman");

        Student student2 = new Student();
        student2.setStudentName("Rakesh");

        Student student3 = new Student();
        student3.setStudentName("Gaurav");

        return List.of(student1, student2, student3);
    }

    private static List<Course> getCourseList() {

        Course course1 = new Course();
        course1.setCourseName("Math");

        Course course2 = new Course();
        course2.setCourseName("CS");

        Course course3 = new Course();
        course3.setCourseName("Mech");

        return List.of(course1, course2, course3);
    }


    //delete
    //update
}
