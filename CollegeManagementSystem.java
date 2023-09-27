package Java_CaseStudy;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int studentID;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Student(int studentID, String name, String email, String phoneNumber, String address) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Other getter and setter methods for phoneNumber and address

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nEmail: " + email;
    }
}

class Course {
    public int courseID;
    public String courseName;
    public String instructor;
    public int credits;
    public int maxCapacity;
    public List<Student> enrolledStudents;

    public Course(int courseID, String courseName, String instructor, int credits, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    // Other getter and setter methods for instructor, credits, and maxCapacity

    public boolean isCourseFull() {
        return enrolledStudents.size() >= maxCapacity;
    }

    public void enrollStudent(Student student) {
        if (!isCourseFull()) {
            enrolledStudents.add(student);
        } else {
            System.out.println("Sorry, the course is already full. Cannot enroll more students.");
        }
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID + "\nCourse Name: " + courseName + "\nInstructor: " + instructor;
    }
}

class CollegeManager {
    public List<Student> students;
    public List<Course> courses;

    public CollegeManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            course.enrollStudent(student);
        } else {
            System.out.println("Student or course not found in the system.");
        }
    }

    public void displayStudentsInCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("Students enrolled in " + course.getCourseName() + ":");
            for (Student student : course.enrolledStudents) {
                System.out.println(student.getName());
            }
        } else {
            System.out.println("Course not found in the system.");
        }
    }

    public void displayCoursesForStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Courses enrolled by " + student.getName() + ":");
            for (Course course : courses) {
                if (course.enrolledStudents.contains(student)) {
                    System.out.println(course.getCourseName());
                }
            }
        } else {
            System.out.println("Student not found in the system.");
        }
    }
}

public class CollegeManagementSystem {
    public static void main(String[] args) {
        // Create instances of Student, Course, and CollegeManager classes
        Student student1 = new Student(1, "Rajesh Kumar", "rajesh@example.com", "123-456-7890", "123 Main St");
        Student student2 = new Student(2, "Priya Sharma", "priya@example.com", "987-654-3210", "456 Elm St");

        Course course1 = new Course(101, "Introduction to Programming", "Prof. Singh", 3, 30);
        Course course2 = new Course(102, "Database Management", "Prof. Joshi", 4, 25);

        CollegeManager collegeManager = new CollegeManager();

        // Add students and courses to the system
        collegeManager.addStudent(student1);
        collegeManager.addStudent(student2);

        collegeManager.addCourse(course1);
        collegeManager.addCourse(course2);

        // Enroll students in courses
        collegeManager.enrollStudentInCourse(student1, course1);
        collegeManager.enrollStudentInCourse(student1, course2);
        collegeManager.enrollStudentInCourse(student2, course1);

        // Display information
        System.out.println("Students:");
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("\nCourses:");
        System.out.println(course1);
        System.out.println(course2);

        System.out.println("\nStudents enrolled in " + course1.getCourseName() + ":");
        collegeManager.displayStudentsInCourse(course1);

        System.out.println("\nCourses enrolled by " + student1.getName() + ":");
        collegeManager.displayCoursesForStudent(student1);
    }
}
