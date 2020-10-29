package junit.real;

import org.junit.jupiter.api.Test;
import tdd.Account;
import tdd.OverWithdrawRequestException;

import static org.junit.jupiter.api.Assertions.*;

public class Example {

  class Calculator {
    public int add(int x, int y) {
      return x + y;
    }
  }

  private final Calculator calculator = new Calculator();

  @Test
  void addition() {
    assertEquals(2, calculator.add(1, 1));
  }

  @Test
  public void paramTest() throws Exception {
    int x = 3;
    assertEquals(3, x, 3);
  }

  @Test
  public void deltaTest() throws Exception {
    assertEquals(0.3333333333333333, 1/3d, 0.00001);

  }

  @Test
  public void sameTest() throws Exception {
    String str1 = "str";
    String str2 = new String("str");
    assertSame("str", str1);
    assertNotSame(str1, str2);
  }

  @Test
  public void trueAndFalseTest() throws Exception {
    assertTrue(true, "assertTrue 테스트 실패");
    assertFalse(false, "assertFalse 테스트 실패");
  }

  @Test
  public void nullCheckTest() throws Exception {
    String str = null;
    assertNull(str, "실패");
    str = "test";
    assertNotNull(str);
  }

  @Test
  public void failTest() throws Exception {
    Account account = new Account(10000);
    try {
      account.withdraw(20000);
      fail("출금 테스트 실패");
    } catch (OverWithdrawRequestException e) {
      assertTrue(true);
    }
  }

}
