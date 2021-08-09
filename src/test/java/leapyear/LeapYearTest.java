package leapyear;

import org.junit.jupiter.api.Test;

import static leapyear.LeapYear.isLeapYear;
import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearTest {

  @Test
  void mostYearsAreACommonYear() {
    int year = 2001;
    // When
    boolean isLeapYear = isLeapYear(year);
    // Then
    assertThat(isLeapYear).isFalse();
  }

  @Test
  void aTypicalLeapYearIsDivisibleByFour() {
    assertThat(isLeapYear(2004)).isTrue();
    assertThat(isLeapYear(1996)).isTrue();
    assertThat(isLeapYear(1995)).isFalse();
  }

  @Test
  void aYearIsAnAtypicalCommonYearWhenDivisibleBy100() {
    assertThat(isLeapYear(1900)).isFalse();
    assertThat(isLeapYear(1800)).isFalse();
    assertThat(isLeapYear(1700)).isFalse();
  }

  @Test
  void aYearIsAnAtypicalLeapYearWhenDivisibleBy400() {
    assertThat(isLeapYear(1600)).isTrue();
    assertThat(isLeapYear(2000)).isTrue();
    assertThat(isLeapYear(1900)).isFalse();
  }
}
