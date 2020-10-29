package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

  private Account account;
  private int money;

  @BeforeEach
  public void setUp() {
    System.out.println("setup");
    try {
      Class<?> aClass = Class.forName("org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.CompositeProcessor");
      String name = aClass.getName();
      System.out.println(name);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    money = 10000;
    account = new Account(money);
  }

  @Test
  void testAccount() throws Exception {
  }

  @Test
  void testGetBalance() throws Exception {
    // then
    assertEquals(money, account.getBalance());
  }

  @Test
  void testDeposit() throws Exception {
    account.deposit(1000);

    // then
    assertEquals(11000, account.getBalance());
  }

  @Test
  void testWithdraw() throws Exception {
    // when
    account.withdraw(1000);

    // then
    assertEquals(9000, account.getBalance());
  }

}
