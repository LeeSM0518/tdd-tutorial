package tdd;

public class Account {

  private int balance;

  public Account(int money) {
    this.balance = money;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int money) {
    this.balance += money;
  }

  public void withdraw(int money) {
    if (balance - money < 0) throw new OverWithdrawRequestException();
    this.balance -= money;
  }

}
