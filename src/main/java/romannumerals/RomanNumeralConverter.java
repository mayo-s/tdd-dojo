package romannumerals;

import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumeralConverter {

  public static void main(String[] args) {
    int[] arabicNumbers = {0, 1, 4, 5, 9, 10, 40, 50, 90, 99, 100, 111, 400, 500, 900, 999, 1000, 1111, 2499, 2021, 1984, 1492, 42, 1337, 3999, 4000};
    for (int arabicNumber : arabicNumbers) {
      System.out.println(arabicNumber + " ==> " + toRoman(arabicNumber));
    }
  }

  public static Optional<String> toRoman(final int arabicNumber) {
    if (arabicNumber < 1 || arabicNumber > 3999) return Optional.empty();

    List<Pair<String, Integer>> romanNumerals = Stream.of(
        Pair.of("M", 1000),
        Pair.of("CM", 900),
        Pair.of("D", 500),
        Pair.of("CD", 400),
        Pair.of("C", 100),
        Pair.of("XC", 90),
        Pair.of("L", 50),
        Pair.of("XL", 40),
        Pair.of("X", 10),
        Pair.of("IX", 9),
        Pair.of("V", 5),
        Pair.of("IV", 4),
        Pair.of("I", 1)
    ).collect(Collectors.toList());

    int rest = arabicNumber;
    StringBuilder romanNumeral = new StringBuilder();
    for (Pair<String, Integer> rn : romanNumerals) {
      romanNumeral.append(rn.getFirst().repeat(rest / rn.getSecond()));
      rest -= rn.getSecond() * (rest / rn.getSecond());
    }

    return Optional.of(romanNumeral.toString());
  }
}
