package romannumerals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static romannumerals.RomanNumeralConverter.arabicToRoman;

public class RomanNumeralConverterTest {

  @Test
  void shouldConvertArabicOneToRomanI() {
    assertThat(arabicToRoman(1)).hasValue("I");
  }

  @Test
  void shouldConvertArabicFiveToRomanV() {
    assertThat(arabicToRoman(5)).hasValue("V");
  }

  @Test
  void shouldConvertArabicTenToRomanX() {
    assertThat(arabicToRoman(10)).hasValue("X");
  }

  @Test
  void shouldConvertArabic50ToRomanL() {
    assertThat(arabicToRoman(50)).hasValue("L");
  }

  @Test
  void shouldConvertArabic100ToRomanC() {
    assertThat(arabicToRoman(100)).hasValue("C");
  }

  @Test
  void shouldConvertArabic500ToRomanD() {
    assertThat(arabicToRoman(500)).hasValue("D");
  }

  @Test
  void shouldConvertArabic1000ToRomanM() {
    assertThat(arabicToRoman(1000)).hasValue("M");
  }

  @Test
  void shouldConvertArabicFourToRomanIV() {
    assertThat(arabicToRoman(4)).hasValue("IV");
  }

  @Test
  void shouldConvertArabicNineToRomanIX() {
    assertThat(arabicToRoman(9)).hasValue("IX");
  }

  @Test
  void shouldConvertArabic40ToRomanXL() {
    assertThat(arabicToRoman(40)).hasValue("XL");
  }

  @Test
  void shouldConvertArabic90ToRomanXC() {
    assertThat(arabicToRoman(90)).hasValue("XC");
  }

  @Test
  void shouldConvertArabic400ToRomanCD() {
    assertThat(arabicToRoman(400)).hasValue("CD");
  }

  @Test
  void shouldConvertArabic900ToRomanCM() {
    assertThat(arabicToRoman(900)).hasValue("CM");
  }

  @Test
  void shouldReturnEmptyOptionalWhenArabicNumberIsLessThanOne() {
    assertThat(arabicToRoman(0)).isEmpty();
    assertThat(arabicToRoman(1)).isNotEmpty();
    assertThat(arabicToRoman(-1)).isEmpty();
  }

  @Test
  void shouldReturnEmptyOptionalWhenArabicNumberIsGreaterThan3999() {
    assertThat(arabicToRoman(3999)).isNotEmpty();
    assertThat(arabicToRoman(4000)).isEmpty();
  }

  @Test
  void shouldConvertArabicNumbersBetweenOneAnd3999() {

    HashMap<Integer, String> expected = new HashMap<>();
    expected.put(2, "II");
    expected.put(2021, "MMXXI");
    expected.put(1984, "MCMLXXXIV");
    expected.put(42, "XLII");
    expected.put(1337, "MCCCXXXVII");
    expected.put(3999, "MMMCMXCIX");

    for (Map.Entry<Integer, String> arabicNumber : expected.entrySet()) {
      assertThat(arabicToRoman(arabicNumber.getKey())).hasValue(arabicNumber.getValue());
    }
  }

}
