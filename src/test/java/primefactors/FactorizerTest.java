package primefactors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static primefactors.Factorizer.findPrimeFactors;

public class FactorizerTest {

  @Test
  void shouldReturnEmptyOptionalWhenNumberLessThanTwo() {
    assertThat(findPrimeFactors(-1)).isEmpty();
    assertThat(findPrimeFactors(0)).isEmpty();
    assertThat(findPrimeFactors(1)).isEmpty();
    assertThat(findPrimeFactors(4)).isNotEmpty();

  }

  @Test
  void shouldReturnEmptyOptionalWhenNumberIsPrime() {
    assertThat(findPrimeFactors(2)).isEmpty();
    assertThat(findPrimeFactors(3)).isEmpty();
    assertThat(findPrimeFactors(4)).isNotEmpty();
    assertThat(findPrimeFactors(5)).isEmpty();
    assertThat(findPrimeFactors(6)).isNotEmpty();

  }

  @Test
  void shouldReturnPrimeFactors() {
    assertThat(findPrimeFactors(6)).containsExactly(2, 3);
    assertThat(findPrimeFactors(4)).containsExactly(2, 2);
    assertThat(findPrimeFactors(12)).containsExactly(2, 2, 3);
    assertThat(findPrimeFactors(15)).containsExactly(3, 5);
    assertThat(findPrimeFactors(28)).containsExactly(2, 2, 7);
    assertThat(findPrimeFactors(124)).containsExactly(2, 2, 31);
    assertThat(findPrimeFactors(1023)).containsExactly(3, 11, 31);
  }

}
