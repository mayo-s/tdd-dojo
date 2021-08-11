package fibonacci;

import org.junit.jupiter.api.Test;

import static fibonacci.Fibonacci.numberAtPosition;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

  @Test
  void shouldReturnZeroWhenPositionLessOrEqualsOne() {
    assertThat(numberAtPosition(-42)).isEqualTo(0);
    assertThat(numberAtPosition(0)).isEqualTo(0);
    assertThat(numberAtPosition(1)).isEqualTo(0);
    assertThat(numberAtPosition(2)).isNotEqualTo(0);
    assertThat(numberAtPosition(3)).isNotEqualTo(0);
  }

  @Test
  void shouldReturnOneWhenPositionEqualsTwo() {
    assertThat(numberAtPosition(2)).isEqualTo(1);
  }

  @Test
  void returnSumOfPrecedingTwoPositionsWhenPositionGreaterOne() {
    assertThat(numberAtPosition(3)).isEqualTo(1);
    assertThat(numberAtPosition(4)).isEqualTo(2);
    assertThat(numberAtPosition(5)).isEqualTo(3);

    for (int n = 3; n < 15; n++) {
      assertThat(numberAtPosition(n)).isEqualTo(numberAtPosition(n - 1) + numberAtPosition(n - 2));
    }
  }

}
