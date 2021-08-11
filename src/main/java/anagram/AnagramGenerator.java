package anagram;

import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {

  private static ArrayList<String> anagrams;

  public static void main(String[] args) {
    anagrams = new ArrayList<>();
    for(String word : generateAnagram("word".toCharArray(), 0)) System.out.println(word);
  }

  public static List<String> generateAnagram(char[] anagram, int i) {

    if (i == anagram.length - 1) anagrams.add(String.valueOf(anagram));
    else {
      for (int j = i; j < anagram.length; j++) {
        char c = anagram[i];
        anagram[i] = anagram[j];
        anagram[j] = c;
        generateAnagram(anagram, i + 1);
        c = anagram[i];
        anagram[i] = anagram[j];
        anagram[j] = c;
      }
    }
    return anagrams;
  }
}
