package romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

  @ParameterizedTest
  @CsvSource({
      "2, 'II'",
      "111, 'CXI'",
      "2021, 'MMXXI'",
      "1984, 'MCMLXXXIV'",
      "42, 'XLII'",
      "1337, 'MCCCXXXVII'",
      "3999, 'MMMCMXCIX'",
  })
  void shouldConvertNumberBetweenOneAnd3999(int number, String expected) {
    assertThat(toRoman(number)).hasValue(expected);
  }
}
