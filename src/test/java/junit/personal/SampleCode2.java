package junit.personal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import test.Calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleCode2 {

  private final Calculator calculator = new Calculator();

  @Test
  public void test() {
    assertEquals(2, calculator.add(1, 1), "성공");
  }

  @ParameterizedTest(name = "{0} + {1} = {2}")
  @CsvSource({
      "0, 1, 1",
      "1, 2, 3",
      "49, 51, 100",
      "1, 100, 101"
  })
   void add(int first, int second, int expectedResult) {
    assertEquals(expectedResult, calculator.add(first, second),
        () -> first + " + " + second + " = " + expectedResult);
  }


}
