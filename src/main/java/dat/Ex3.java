package dat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4, 56, 60, 69, 182};

        //Predicate
        Predicate<Integer> thirds = x -> x % 3 == 0;
        for (int i : a) {
            if(thirds.test(i)){
                System.out.println(i);
            }

        }

        //Supplier
        Supplier<List<Employee>> employeeSupplier = () -> {

            List<String> employeeList = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
            Employee[] employees = new Employee[employeeList.size()];

            for (int i = 0; i < employeeList.size(); i++) {
                employees[i] = new Employee(employeeList.get(i));
            }
            return List.of(employees);
            
         };
        System.out.println(employeeSupplier.get());

        //Consumer
        Consumer<List<Employee>> consumer = employees -> {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        };

        //Function
        Function<List<Employee>, List<String>> function = employees-> {
            List<String> nameList = new ArrayList<>();
            for (Employee employee : employees) {
                nameList.add(employee.getName());
            }
            return nameList;
        };

        //Predicate
        Predicate<Employee> ageCheck = employee -> {
            if(employee.getAge() > 18){
                return true;
            }
            else {
                return false;
            }
        };

        //consumer
        List<String> employees = new ArrayList<>();
        employees = List.of(new String[]{"Lars", "Peter", "Mads"});
        List<String> finalEmployees = employees;
        Consumer<List<String>> writeFile = x -> {
            try {
                writeToFile(finalEmployees);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };



    }

    static void writeToFile(List<String> employees) throws IOException {
        FileWriter fileWriter = new FileWriter("newfile.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (String e : employees) {
            writer.write(e);
        }
        writer.close();
    }

}
