package romannumerals;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumeralConverter {

  public static void main(String[] args) {

    int[] arabicNumbers = {1, 5, 10, 50, 100, 500, 1000, 2021, 1984, 1492, 42, 1337};
    for(int arabicNumber : arabicNumbers) {
      System.out.println(arabicNumber + " ==> " + arabicToRoman(arabicNumber));
    }
  }

  public static String arabicToRoman(int arabicNumber) {

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

    for(Pair<String, Integer> rn : romanNumerals) {
      Pair<String, Integer> numeral = Pair.of(rn.getFirst(), arabicNumber / rn.getSecond());
      numerals.add(numeral);
      arabicNumber -= rn.getSecond() * numeral.getSecond();
    }

    String romanNumeral = "";
    for (Pair<String, Integer> numeral : numerals) {
      romanNumeral += numeral.getFirst().repeat(numeral.getSecond());
    }
    return romanNumeral;
  }
}
