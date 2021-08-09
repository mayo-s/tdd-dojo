package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static fizzbuzz.FizzBuzz.fizzBuzzNumber;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {


    @Test
    @DisplayName("Should return input as String")
    void shouldReturnANumberString() {
        // Given
        int number = 1;
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer.equals(Integer.toString(number))).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, TRUE",
            "2, TRUE",
            "3, FALSE",
            "4, TRUE",
            "5, FALSE",
            "15, FALSE"
    })
    @DisplayName("Should return number as String if not dividable by 3 and/or 5")
    void shouldReturnNumberAsString(int number, boolean expected) {
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer.equals(Integer.toString(number))).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, FALSE",
            "2, FALSE",
            "3, TRUE",
            "4, FALSE",
            "5, FALSE",
            "6, TRUE",
            "15, FALSE"
    })
    @DisplayName("Should return Fizz if only dividable by 3")
    void shouldReturnFizz(int number, boolean expected) {
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer.equals("Fizz")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, FALSE",
            "2, FALSE",
            "3, FALSE",
            "4, FALSE",
            "5, TRUE",
            "6, FALSE",
            "10, TRUE",
            "15, FALSE"
    })
    @DisplayName("Should return Buzz if only dividable by 5")
    void shouldReturnBuzz(int number, boolean expected) {
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer.equals("Buzz")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, FALSE",
            "2, FALSE",
            "3, FALSE",
            "4, FALSE",
            "5, FALSE",
            "6, FALSE",
            "15, TRUE",
            "20, FALSE",
            "30, TRUE"
    })
    @DisplayName("Should return FizzBuzz if dividable by 3 and 5")
    void shouldReturnFizzBuzz(int number, boolean expected) {
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer.equals("FizzBuzz")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, '1'",
            "2, '2'",
            "3, 'Fizz'",
            "4, '4'",
            "5, 'Buzz'",
            "6, 'Fizz'",
            "15, 'FizzBuzz'",
            "20, 'Buzz'",
            "30, 'FizzBuzz'"
    })
    @DisplayName("Should return FizzBuzz if dividable by 3 and 5")
    void shouldReturnFizzBuzz(int number, String expected) {
        // When
        String fizzBuzzAnswer = fizzBuzzNumber(number);
        // Then
        assertThat(fizzBuzzAnswer).isEqualTo(expected);
    }
}
