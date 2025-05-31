import java.util.ArrayList;
import java.util.List;

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        RegistrationManager manager = new RegistrationManager();

        // Create students with accounts
        Account acc1 = new Account("sadia123", "pass123");
        Student s1 = new Student("S001", "Sadia Rahman", acc1);

        Account acc2 = new Account("nafisa456", "abc456");
        Student s2 = new Student("S002", "Nafisa Tasfia", acc2);

        // Create courses
        Course c1 = new Course("CSE101", "Introduction to Programming");
        Course c2 = new Course("MAT110", "Discrete Mathematics");

        // Add to manager
        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addCourse(c1);
        manager.addCourse(c2);

        // Register students for courses
        manager.register(s1, c1);
        manager.register(s2, c1);
        manager.register(s1, c2);

        // Display registrations
        manager.showAllRegistrations();
    }
}

// ---------------------- Account.java ----------------------
class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// ---------------------- Student.java ----------------------
class Student {
    private String studentId;
    private String name;
    private Account account;

    public Student(String studentId, String name, Account account) {
        this.studentId = studentId;
        this.name = name;
        this.account = account;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}

// ---------------------- Course.java ----------------------
class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}

// ---------------------- Registration.java ----------------------
class Registration {
    private Student student;
    private Course course;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}

// ---------------------- RegistrationManager.java ----------------------
class RegistrationManager {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getCourseName());
    }

    public void register(Student student, Course course) {
        Registration registration = new Registration(student, course);
        registrations.add(registration);
        System.out.println(student.getName() + " registered for " + course.getCourseName());
    }

    public void showAllRegistrations() {
        System.out.println("\n--- All Registrations ---");
        for (Registration r : registrations) {
            System.out.println(r.getStudent().getName() + " --> " + r.getCourse().getCourseName());
        }
    }
}
