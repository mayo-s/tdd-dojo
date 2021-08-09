package fizzbuzz;

import java.util.Arrays;

public class FizzBuzz {

    private static int[] numbers;

    public static void main(String[] args) {
        numbers = new int[100];
        Arrays.setAll(numbers, i -> i+1);
        for(int i : numbers) {
            System.out.println(i + " " + fizzBuzzNumber(i)) ;
        }
    }

    public static String fizzBuzzNumber(int number) {
        if(number%3 == 0 && number%5 == 0) return "FizzBuzz";
        else if(number%3 == 0) return "Fizz";
        else if(number%5 == 0) return "Buzz";
        return String.valueOf(number);
    }
}
