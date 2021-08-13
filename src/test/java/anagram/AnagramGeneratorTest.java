package anagram;

import org.junit.jupiter.api.Test;

import java.util.List;

import static anagram.AnagramGenerator.generateAnagrams;
import static org.assertj.core.api.Assertions.assertThat;

public class AnagramGeneratorTest {
  private char[] word = "word".toCharArray();

  @Test
  void shouldReturnListOfStrings() {
    assertThat(generateAnagrams(word, 0) instanceof List).isTrue();
  }

  @Test
  void shouldContainOriginWord() {
    assertThat(generateAnagrams(word, 0)).contains("word");
  }

  @Test
  void shouldContainAnagramOfOriginWord() {
    assertThat(generateAnagrams(word, 0)).contains("wodr");
    assertThat(generateAnagrams(word, 0)).contains("wrod");
    assertThat(generateAnagrams(word, 0)).contains("wrdo");
    assertThat(generateAnagrams(word, 0)).contains("wdro");
    assertThat(generateAnagrams(word, 0)).contains("wdor");
  }
}
