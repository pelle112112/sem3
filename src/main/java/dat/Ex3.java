package dat;

import java.lang.constant.Constable;
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
        Function<List<Employee>>



    }



}
