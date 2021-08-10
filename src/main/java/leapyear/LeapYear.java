package leapyear;

public class LeapYear {
  public static boolean isLeapYear(int year) {
    if (divisibleBy(400, year)) return true;
    if (divisibleBy(100, year)) return false;
    return divisibleBy(4, year);
  }

  private static boolean divisibleBy(int divisor, int year) {
    return year % divisor == 0;
  }
}
