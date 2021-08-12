package romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import static org.assertj.core.api.Assertions.assertThat;
import static romannumerals.RomanNumeralConverter.arabicToRoman;

public class RomanNumeralConverterTest {

  @Test
  void shouldAnswerWithAString() {
    assertThat(arabicToRoman(1) instanceof String).isTrue();
  }

  @Test
  void shouldConvertArabicOneToRomanI() {
    assertThat(arabicToRoman(1)).isEqualTo("I");
  }

  @Test
  void shouldConvertArabicFiveToRomanV() {
    assertThat(arabicToRoman(5)).isEqualTo("V");
  }

  @Test
  void shouldConvertNumbersLessThanTen() {
    assertThat(arabicToRoman(2)).isEqualTo("II");
    assertThat(arabicToRoman(3)).isEqualTo("III");
    // TODO 4 should be IV
    assertThat(arabicToRoman(4)).isEqualTo("IIII");
    assertThat(arabicToRoman(6)).isEqualTo("VI");
    assertThat(arabicToRoman(7)).isEqualTo("VII");
    assertThat(arabicToRoman(8)).isEqualTo("VIII");
    // TODO 9 should be IX
    assertThat(arabicToRoman(9)).isEqualTo("VIIII");
  }

  @Test
  void shouldConvertArabicTenToRomanX() {
    assertThat(arabicToRoman(10)).isEqualTo("X");
  }

  @Test
  void shouldConvertArabic50ToRomanL() {
    assertThat(arabicToRoman(50)).isEqualTo("L");
  }

  @Test
  void shouldConvertArabic100ToRomanC() {
    assertThat(arabicToRoman(100)).isEqualTo("C");
  }

  @Test
  void shouldConvertArabic500ToRomanD() {
    assertThat(arabicToRoman(500)).isEqualTo("D");
  }

  @Test
  void shouldConvertArabic1000ToRomanM() {
    assertThat(arabicToRoman(1000)).isEqualTo("M");
  }

  @Test
  void shouldConvertArabicNumbersUpTo4999() {
    Pair[] arabicNumbers = {
        Pair.of(2, "II"),
        Pair.of(2021, "MMXXI"),
        // TODO 900 should be CM, 4 should be IV
        Pair.of(1984, "MDCCCCLXXXIIII"),
        // TODO 40 should be XL
        Pair.of(42, "XXXXII"),
        Pair.of(1337, "MCCCXXXVII"),
    };
    for(Pair<Integer, String> arabicNumber : arabicNumbers) {
      assertThat(arabicToRoman(arabicNumber.getFirst())).isEqualTo(arabicNumber.getSecond());
    }
  }

}
