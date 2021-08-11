package statscalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static statscalculator.StatsCalculator.*;

public class StatsCalculatorTest {

  int[] numbers = {6, 9, 15, -2, 42, 11};

  @Test
  void shouldReturnMinimumValueOfGivenSequence() {
    assertThat(getMin(numbers)).isEqualTo(-2);
  }

  @Test
  void shouldReturnMaximumValueOfGivenSequence() {
    assertThat(getMax(numbers)).isEqualTo(42);
  }

  @Test
  void shouldReturnNumberOfElementsInSequence() {
    assertThat(getSequenceSize(numbers)).isEqualTo(6);
  }

  @Test
  void shouldReturnAverageValueOfGivenSequence() {
    assertThat(getAverage(numbers)).isEqualTo(13.5);
  }
}
