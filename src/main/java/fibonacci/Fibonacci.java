package fibonacci;

public class Fibonacci {

  // f(n) = f(n - 2) + f(n - 1)
  public static int numberAtPosition(int position) {
    int nMinusTwo = 0;
    if (position <= 1) return nMinusTwo;
    int nMinusOne = 1;
    do {
      int n = nMinusTwo + nMinusOne;
      nMinusTwo = nMinusOne;
      nMinusOne = n;
      position--;
    } while (position > 2);

    return nMinusOne;
  }
}
