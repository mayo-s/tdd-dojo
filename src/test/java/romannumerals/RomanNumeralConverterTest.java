package romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import static org.assertj.core.api.Assertions.assertThat;
import static romannumerals.RomanNumeralConverter.arabicToRoman;

public class RomanNumeralConverterTest {

  @Test
  void shouldConvertArabicOneToRomanI() {
    assertThat(arabicToRoman(1).get()).isEqualTo("I");
  }

  @Test
  void shouldConvertArabicFiveToRomanV() {
    assertThat(arabicToRoman(5).get()).isEqualTo("V");
  }

  @Test
  void shouldConvertArabicTenToRomanX() {
    assertThat(arabicToRoman(10).get()).isEqualTo("X");
  }

  @Test
  void shouldConvertArabic50ToRomanL() {
    assertThat(arabicToRoman(50).get()).isEqualTo("L");
  }

  @Test
  void shouldConvertArabic100ToRomanC() {
    assertThat(arabicToRoman(100).get()).isEqualTo("C");
  }

  @Test
  void shouldConvertArabic500ToRomanD() {
    assertThat(arabicToRoman(500).get()).isEqualTo("D");
  }

  @Test
  void shouldConvertArabic1000ToRomanM() {
    assertThat(arabicToRoman(1000).get()).isEqualTo("M");
  }

  @Test
  void assertThatOptionalIsEmptyWhenArabicNumberIsLessThanOne() {
    assertThat(arabicToRoman(0)).isEmpty();
    assertThat(arabicToRoman(1)).isNotEmpty();
    assertThat(arabicToRoman(-1)).isEmpty();
  }

  @Test
  void assertThatOptionalIsEmptyWhenArabicNumberIsGreaterThan3999() {
    assertThat(arabicToRoman(3999)).isNotEmpty();
    assertThat(arabicToRoman(4000)).isEmpty();
  }

  @Test
  void shouldConvertArabicNumbersBetweenOneAnd3999() {
    Pair[] arabicNumbers = {
        Pair.of(2, "II"),
        Pair.of(2021, "MMXXI"),
        // TODO 900 should be CM, 4 should be IV
        // Pair.of(1984, "MDCDLXXXIV"),
        // TODO 40 should be XL
        // Pair.of(42, "XLII"),
        Pair.of(1337, "MCCCXXXVII"),
        // Pair.of(3999, "MMMCMXCIX"),
    };
    for(Pair<Integer, String> arabicNumber : arabicNumbers) {
      assertThat(arabicToRoman(arabicNumber.getFirst()).get()).isEqualTo(arabicNumber.getSecond());
    }
  }

}
