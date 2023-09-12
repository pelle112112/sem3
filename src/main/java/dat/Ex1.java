package dat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1 {

    @FunctionalInterface
    interface ArithmeticOperation {
        float perform(float a, float b);
    }



    public static void main(String[] args) {
        System.out.println("Hello functional");

        ArithmeticOperation addition = (a,b) -> a + b;
        System.out.println("Add 5 + 6: " + addition.perform(5,6));

        ArithmeticOperation subtraction = (a, b) -> a - b;
        System.out.println("Subtract 15 - 6: " + subtraction.perform(15,6));

        ArithmeticOperation multiplication = (a,b) -> a*b;
        System.out.println("Multiplicate 3 * 4: " + multiplication.perform(3,4));

        ArithmeticOperation division = (a,b) -> a/b;
        System.out.println("Divide 10 / 2: " + division.perform(10,2));

        ArithmeticOperation modulus = (a,b) -> a%b;
        System.out.println("Modulus 12 % 5: " + modulus.perform(12,5));

        ArithmeticOperation power = (a,b) -> (float) Math.pow(a,b);
        System.out.println("Power 2^3: " + power.perform(2,3));

        System.out.println(operate(22, 8, addition));

        float[] a = {1,2,3,4,5};
        float[] b = {6,7,8,9,10};


        showArray(operate(a,b,subtraction));


    }
    static float operate(float a, float b, ArithmeticOperation op){
        return op.perform(a,b);
    }


    static float[] operate(float[] a, float[] b, ArithmeticOperation op){
        float[] result = new float[a.length];
        if(a.length != b.length){
            System.out.println("Uens antal tal i arrays");
        }else {
            for (int i = 0; i < a.length; i++) {
                result[i] = op.perform(a[i], b[i]);
            }
        }
        return result;
    }
    static void showArray(float[] result){
        System.out.println(Arrays.toString(result));
    }

}
