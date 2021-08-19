package primefactors;

import java.util.*;

public class Factorizer {

  private static List<Integer> primeFactors;

  public static int[] findPrimeFactors(final int number) {

    if (number <= 1) return new int[]{};
    if (isPrime(number)) return new int[]{};

    primeFactors = new ArrayList<>();
    factorize(number, getMaxPrime(number));

    return primeFactors.stream().sorted().mapToInt(v -> v).toArray();
  }

  public static void factorize(final int number, final int factor) {
    if (isPrime(factor) && number % factor == 0) {
      primeFactors.add(factor);
      int quotient = number / factor;
      if(!isPrime(quotient)) factorize(quotient, getMaxPrime(quotient));
      else primeFactors.add(quotient);
    }
    else factorize(number, factor - 1);
  }

  private static int getMaxPrime(int number) {
    int maxPrime = 2;
    for (int n = maxPrime; n <= number / 2; n++) {
      if (isPrime(n)) maxPrime = n;

    }
    return maxPrime;
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); ++i) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

//  https://www.baeldung.com/java-generate-prime-numbers
//  private static boolean isPrime(int number) {
//    return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
//        .allMatch(n -> x % n != 0);
//  }
}
