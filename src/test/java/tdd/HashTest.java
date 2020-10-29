package tdd;

import java.util.Objects;

public class HashTest {

  private String name;

  public HashTest(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if ((obj instanceof String)) return false;
    String str = (String) obj;
    return Objects.equals(name, str);
  }
}
