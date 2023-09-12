package dat;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class Ex4 {
    interface newValidating{
        boolean validate(int month);
    }
    public static void main(String[] args) {
        String[] nameList = {"Mads", "Peter", "Lars", "Irene", "Lise"};

        List<Employee> employeeList = createEmployeeList(List.of(nameList));
        System.out.println(employeeList.toString());
        //Calculate age
        System.out.println("Average age is: " + calculateAge(employeeList));
        //filter
        List<Employee> resultEmployees = filterBirthdays(employeeList, month -> month == 9);
        System.out.println("Results of month filter: " + resultEmployees);
        //Month count
        System.out.println("People with birthday in september: " + displayMonthCount(employeeList, 9));
        //Display people with bithday
        System.out.println("People with birthday this month " + filterPeopleWithBirthdayThisMonth(employeeList));

    }
    static int[] map(int[] a, Ex2.MyTransformingType op){
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }

    static List<Employee> createEmployeeList (List<String> strings){
        List<String> employeeList = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
        LocalDate[] localDates = {LocalDate.of(1998, 2, 23), LocalDate.of(1994, 4, 23), LocalDate.of(1990, 9, 23), LocalDate.of(1980, 9, 23), LocalDate.of(1972, 10, 23)};
        List<Employee> employeeList2 = new ArrayList<>();
        Employee[] employees = new Employee[employeeList.size()];

        for (int i = 0; i < employeeList.size(); i++) {
            employeeList2.add(new Employee(employeeList.get(i), localDates[i]));
        }
        return employeeList2;

    }
    static int calculateAge (List<Employee> employees){
        int totalAge = 0;
        int averageAge = 0;
        int[] ages = new int[employees.size()];
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < employees.size(); i++) {
            ages[i] = Period.between(employees.get(i).getLocalDate(), currentDate).getYears();
        }
        for (int i = 0; i < ages.length; i++) {
            totalAge = totalAge + ages[i];
        }
        averageAge = totalAge/ages.length;
        return averageAge;
    }
    static List<Employee> filterBirthdays(List<Employee> employees, newValidating ex){

        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if(ex.validate(e.getLocalDate().getMonthValue())){
                filteredEmployees.add(e);
            }
        }
        return filteredEmployees;
    }
    static int displayMonthCount (List<Employee> employees, int month){
        List<Employee> sortedList = employees.stream()
                .filter(employee -> employee.getLocalDate().getMonthValue() == month)
                .collect(Collectors.toList());

        return sortedList.size();
    }
    static List<Employee> filterPeopleWithBirthdayThisMonth (List<Employee> employees){
        List<Employee> sortedList = employees.stream()
                .filter(employee -> employee.getLocalDate().getMonthValue() == LocalDate.now().getMonthValue())
                .collect(Collectors.toList());

        return sortedList;
    }

}
