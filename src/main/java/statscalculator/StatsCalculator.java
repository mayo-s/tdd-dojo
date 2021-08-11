package statscalculator;

import java.util.Arrays;

public class StatsCalculator {

  public static int getMin(int[] numbers) {
    return Arrays.stream(numbers).min().getAsInt();
  }

  public static int getMax(int[] numbers) {
    return Arrays.stream(numbers).max().getAsInt();
  }

  public static double getAverage(int[] numbers) {
    return Arrays.stream(numbers).average().getAsDouble();
  }

  public static double getSequenceSize(int[] numbers) {
    return Arrays.stream(numbers).count();
//    return numbers.length;
  }
}
