package dat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private LocalDate localDate = LocalDate.of(1998, 2, 23);


    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, LocalDate localDate) {
        this.name = name;
        this.localDate = localDate;

    }
}
