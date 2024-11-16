import java.util.*;
import java.util.stream.Collectors;

class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    // Конструктор
    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "Doe", 25, "USA"));
        users.add(new User(2, "Jane", "Smith", 30, "Canada"));
        users.add(new User(3, "Tom", "Brown", 12, "USA"));
        users.add(new User(4, "Alice", "Johnson", 8, "UK"));
        users.add(new User(5, "Bob", "Davis", 19, "Canada"));

        // 1. Вывести всех пользователей, отсортированных по lastName
        System.out.println("Users sorted by last name:");
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);

        // 2. Вывести всех пользователей, отсортированных по age
        System.out.println("\nUsers sorted by age:");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);

        // 3. Проверить, что все пользователи имеют возраст > 7
        boolean allAbove7 = users.stream().allMatch(user -> user.getAge() > 7);
        System.out.println("\nAll users are older than 7: " + allAbove7);

        // 4. Вычислить средний возраст всех пользователей
        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average age of users: " + averageAge);

        // 5. Вывести количество разных стран проживания среди пользователей
        long uniqueCountriesCount = users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
        System.out.println("Number of different countries: " + uniqueCountriesCount);
    }
}
