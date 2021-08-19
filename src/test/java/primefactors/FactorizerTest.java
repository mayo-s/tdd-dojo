package primefactors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static primefactors.Factorizer.findPrimeFactors;

public class FactorizerTest {

  @Test
  void shouldReturnEmptyArrayWhenNumberLessThanTwo() {
    assertThat(findPrimeFactors(-1)).isEmpty();
    assertThat(findPrimeFactors(0)).isEmpty();
    assertThat(findPrimeFactors(1)).isEmpty();
    assertThat(findPrimeFactors(4)).isNotEmpty();

  }

  @Test
  void shouldReturnPrimeFactors() {
    assertThat(findPrimeFactors(2)).containsExactly(2);
    assertThat(findPrimeFactors(3)).containsExactly(3);
    assertThat(findPrimeFactors(4)).containsExactly(2, 2);
    assertThat(findPrimeFactors(6)).containsExactly(2, 3);
    assertThat(findPrimeFactors(12)).containsExactly(2, 2, 3);
    assertThat(findPrimeFactors(15)).containsExactly(3, 5);
    assertThat(findPrimeFactors(28)).containsExactly(2, 2, 7);
    assertThat(findPrimeFactors(42)).containsExactly(2, 3, 7);
    assertThat(findPrimeFactors(124)).containsExactly(2, 2, 31);
    assertThat(findPrimeFactors(1023)).containsExactly(3, 11, 31);
    assertThat(findPrimeFactors(1024)).containsExactly(2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
    assertThat(findPrimeFactors(1337)).containsExactly(7, 191);
    assertThat(findPrimeFactors(5555)).containsExactly(5, 11, 101);
    assertThat(findPrimeFactors(10023)).containsExactly(3, 13, 257);
    assertThat(findPrimeFactors(10024)).containsExactly(2, 2, 2, 7, 179);
//    TODO Will result in endless loop - Check why!
//    assertThat(findPrimeFactors(100023)).containsExactly(3, 7, 11, 433);
//    assertThat(findPrimeFactors(100024)).containsExactly(2, 2, 2, 12503);¬
  }

}
