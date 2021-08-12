package romannumerals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static romannumerals.RomanNumeralConverter.toRoman;

public class RomanNumeralConverterTest {

  @Test
  void shouldConvertArabicOneToRomanI() {
    assertThat(toRoman(1)).hasValue("I");
  }

  @Test
  void shouldConvertArabicFiveToRomanV() {
    assertThat(toRoman(5)).hasValue("V");
  }

  @Test
  void shouldConvertArabicTenToRomanX() {
    assertThat(toRoman(10)).hasValue("X");
  }

  @Test
  void shouldConvertArabic50ToRomanL() {
    assertThat(toRoman(50)).hasValue("L");
  }

  @Test
  void shouldConvertArabic100ToRomanC() {
    assertThat(toRoman(100)).hasValue("C");
  }

  @Test
  void shouldConvertArabic500ToRomanD() {
    assertThat(toRoman(500)).hasValue("D");
  }

  @Test
  void shouldConvertArabic1000ToRomanM() {
    assertThat(toRoman(1000)).hasValue("M");
  }

  @Test
  void shouldConvertArabicFourToRomanIV() {
    assertThat(toRoman(4)).hasValue("IV");
  }

  @Test
  void shouldConvertArabicNineToRomanIX() {
    assertThat(toRoman(9)).hasValue("IX");
  }

  @Test
  void shouldConvertArabic40ToRomanXL() {
    assertThat(toRoman(40)).hasValue("XL");
  }

  @Test
  void shouldConvertArabic90ToRomanXC() {
    assertThat(toRoman(90)).hasValue("XC");
  }

  @Test
  void shouldConvertArabic400ToRomanCD() {
    assertThat(toRoman(400)).hasValue("CD");
  }

  @Test
  void shouldConvertArabic900ToRomanCM() {
    assertThat(toRoman(900)).hasValue("CM");
  }

  @Test
  void shouldReturnEmptyOptionalWhenArabicNumberIsLessThanOne() {
    assertThat(toRoman(0)).isEmpty();
    assertThat(toRoman(1)).isNotEmpty();
    assertThat(toRoman(-1)).isEmpty();
  }

  @Test
  void shouldReturnEmptyOptionalWhenArabicNumberIsGreaterThan3999() {
    assertThat(toRoman(3999)).isNotEmpty();
    assertThat(toRoman(4000)).isEmpty();
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
      assertThat(toRoman(arabicNumber.getKey())).hasValue(arabicNumber.getValue());
    }
  }
}
