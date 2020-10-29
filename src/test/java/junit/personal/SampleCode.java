package junit.personal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


@DisplayName("라이프사이클 설명을 위한 클래스")
public class SampleCode {

//  @BeforeAll
//  static void initializeBeforeAll() {
//    System.out.println("initializeBeforeAll");
//  }
//
//  @BeforeEach
//  void initializeBeforeEach() {
//    System.out.println("initializeBeforeEach");
//  }
//
////  @Test
////  @DisplayName("@Test를 사용하는 첫 번째 테스트")
////  void firstTest() {
////    System.out.println("첫번째 테스트");
////    Assertions.assertTrue(true);
////  }
////  @Test
////  @DisplayName("@Test를 사용하는 첫 번째 테스트")
////  void secondTest() {
////    System.out.println("두번째 테스트");
////    Assertions.assertTrue(true);
////  }
//
//  @Test
////  @Disabled
////  @DisplayName("@Disabled를 사용하는 스킵 테스트")
//  void testMethod1() {
//    System.out.println("test1");
//  }
//  @Test
////  @Disabled
////  @DisplayName("@Disabled를 사용하는 스킵 테스트")
//  void testMethod2() {
//    System.out.println("test2");
//  }
//
//  @AfterEach
//  void afterEach() {
//    System.out.println("afterEach");
//  }
//
//  @AfterAll
//  static void afterAll() {
//    System.out.println("afterAll");
//  }

//  @BeforeAll
//  static void initializeBeforeAll() {
//    System.out.println("전체 초기화");
//  }
//
//  @BeforeEach
//  void initializeBeforeEach() {
//    System.out.println("개별 초기화");
//  }
//
//  @Test
//  void testMethod1() {
//    System.out.println("테스트 1");
//  }
//
//  @Test
//  void testMethod2() {
//    System.out.println("테스트 2");
//  }
//
//  @AfterEach
//  void afterEach() {
//    System.out.println("개별 해제");
//  }
//
//  @AfterAll
//  static void afterAll() {
//    System.out.println("전체 해제");
//  }

  @Test
  public void exceptionTest() {
    Assertions.assertThrows(NumberFormatException.class,
        () -> Integer.parseInt("asd"));
  }

  @Test
  @Disabled
  public void timeoutTest() throws InterruptedException {
    TimeUnit.SECONDS.sleep(10);
  }

  @Test
  public void arrayTest() {
    int[] x = {1, 2, 3};
    int[] y = {1, 2, 3};

    Assertions.assertArrayEquals(x, y);
  }

}
