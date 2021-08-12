package romannumerals;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumeralConverter {

  public static void main(String[] args) {

    int[] arabicNumbers = {0, 1, 4, 5, 9, 10, 40, 50, 90, 99, 100, 400, 500, 900, 1000, 2499, 2021, 1984, 1492, 42, 1337, 4999, 5000};
    for (int arabicNumber : arabicNumbers) {
      System.out.println(arabicNumber + " ==> " + arabicToRoman(arabicNumber));
    }
  }

  public static Optional<String> arabicToRoman(int arabicNumber) {
    if (arabicNumber < 1 || arabicNumber > 3999) return Optional.empty();

    List<Pair<String, Integer>> romanNumerals = Stream.of(
        Pair.of("M", 1000),
        Pair.of("D", 500),
        Pair.of("C", 100),
        Pair.of("L", 50),
        Pair.of("X", 10),
        Pair.of("V", 5),
        Pair.of("I", 1)
    ).collect(Collectors.toList());

    ArrayList<Pair<String, Integer>> numerals = new ArrayList<>();

    for (Pair<String, Integer> rn : romanNumerals) {
      Pair<String, Integer> numeral = Pair.of(rn.getFirst(), arabicNumber / rn.getSecond());
      numerals.add(numeral);
      arabicNumber -= rn.getSecond() * numeral.getSecond();
    }

    String romanNumeral = "";
    for (Pair<String, Integer> numeral : numerals) {
        romanNumeral += numeral.getFirst().repeat(numeral.getSecond());
    }
    return Optional.of(romanNumeral);
  }
}
