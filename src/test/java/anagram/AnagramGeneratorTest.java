package anagram;

import org.junit.jupiter.api.Test;

import java.util.List;

import static anagram.AnagramGenerator.generateAnagram;
import static org.assertj.core.api.Assertions.assertThat;

public class AnagramGeneratorTest {
  private char[] word = "word".toCharArray();

  @Test
  void shouldReturnSetOfStrings() {
    assertThat(generateAnagram(word, 0) instanceof List).isTrue();
  }

  @Test
  void shouldContainOriginWord() {
    assertThat(generateAnagram(word, 0)).contains("word");
  }

  @Test
  void shouldContainAnagramOfOriginWord() {
    assertThat(generateAnagram(word, 0)).contains("wodr");
    assertThat(generateAnagram(word, 0)).contains("wrod");
    assertThat(generateAnagram(word, 0)).contains("wrdo");
    assertThat(generateAnagram(word, 0)).contains("wdro");
    assertThat(generateAnagram(word, 0)).contains("wdor");
  }
}
