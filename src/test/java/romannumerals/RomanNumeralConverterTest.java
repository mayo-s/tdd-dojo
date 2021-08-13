package romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static romannumerals.RomanNumeralConverter.toRoman;

public class RomanNumeralConverterTest {

  @Test
  void shouldConvertOneToRomanNumeralI() {
    assertThat(toRoman(1)).hasValue("I");
  }

  @Test
  void shouldConvertFiveToRomanNumeralV() {
    assertThat(toRoman(5)).hasValue("V");
  }

  @Test
  void shouldConvertTenToRomanNumeralX() {
    assertThat(toRoman(10)).hasValue("X");
  }

  @Test
  void shouldConvert50ToRomanNumeralL() {
    assertThat(toRoman(50)).hasValue("L");
  }

  @Test
  void shouldConvert100ToRomanNumeralC() {
    assertThat(toRoman(100)).hasValue("C");
  }

  @Test
  void shouldConvert500ToRomanNumeralD() {
    assertThat(toRoman(500)).hasValue("D");
  }

  @Test
  void shouldConvert1000ToRomanNumeralM() {
    assertThat(toRoman(1000)).hasValue("M");
  }

  @Test
  void numberFourIsDeclaredAsRomanNumeralIV() {
    assertThat(toRoman(4)).hasValue("IV");
  }

  @Test
  void numberNineIsDeclaredAsRomanNumeralIX() {
    assertThat(toRoman(9)).hasValue("IX");
  }

  @Test
  void number40IsDeclaredAsRomanNumeralXL() {
    assertThat(toRoman(40)).hasValue("XL");
  }

  @Test
  void number90IsDeclaredAsRomanNumeralXC() {
    assertThat(toRoman(90)).hasValue("XC");
  }

  @Test
  void number400IsDeclaredAsRomanNumeralCD() {
    assertThat(toRoman(400)).hasValue("CD");
  }

  @Test
  void number900IsDeclaredAsRomanNumeralCM() {
    assertThat(toRoman(900)).hasValue("CM");
  }

  @Test
  void shouldReturnEmptyOptionalWhenNumberIsLessThanOne() {
    assertThat(toRoman(1)).isNotEmpty();
    assertThat(toRoman(0)).isEmpty();
    assertThat(toRoman(-1)).isEmpty();
  }

  @Test
  void shouldReturnEmptyOptionalWhenNumberIsGreaterThan3999() {
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
