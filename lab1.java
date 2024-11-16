import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Double> grades;

    public Student(String name, String group, int course, List<Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void promote() {
        this.course++;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group + "', course=" + course + ", grades=" + grades + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "A1", 1, List.of(4.0, 5.0, 3.5)));
        students.add(new Student("Bob", "B1", 2, List.of(2.0, 3.0, 1.5)));
        students.add(new Student("Charlie", "C1", 1, List.of(3.0, 2.5, 4.0)));
        students.add(new Student("David", "A1", 3, List.of(5.0, 4.5, 3.0)));

        removeAndPromoteStudents(students);
        
        // Выводим студентов 2 курса
        printStudents(students, 2);
        
        // Выводим студентов 3 курса
        printStudents(students, 3);
        
        // Выводим студентов 4 курса
        printStudents(students, 4);
    }

    public static void removeAndPromoteStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        
        // Сначала сохраняем студентов, которые будут повышены
        List<Student> toPromote = new ArrayList<>();
        
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double average = student.calculateAverage();
            if (average < 3) {
                iterator.remove(); // Удаляем студента
            } else {
                toPromote.add(student); // Добавляем студента для повышения
            }
        }
        
        // Повышаем курс для студентов с достаточным средним баллом
        for (Student student : toPromote) {
            student.promote();
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Students in course " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
