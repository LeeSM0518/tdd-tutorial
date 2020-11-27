package mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

  @Test
  @DisplayName("BDDMockito.given()을 이용한 스텁 설정")
  void givenNoneWhenGameNumGenerateThenReturnGameNum() {
    // given
    // when
    GameNumGen genMock = mock(GameNumGen.class);
    given(genMock.generate(GameLevel.EASY)).willReturn("123");

    String num = genMock.generate(GameLevel.EASY);

    // then
    assertEquals("123", num);
  }

  @Test
  @DisplayName("특정 타입의 익셉션을 발생하도록 스텁 설정")
  void givenNoneWhenGameNumGenerateThenReturnException() {
    // given
    // when
    GameNumGen genMock = mock(GameNumGen.class);
    given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

    // then
    assertThrows(IllegalArgumentException.class,
        () -> genMock.generate(null));
  }

  @Test
  @DisplayName("void인 메서드에 대해 익셉션 발생")
  void givenNoneWhenListCreateThenReturnThrows() {
    // given
    // when
    List<String> mockList = mock(List.class);
    willThrow(UnsupportedOperationException.class)
        .given(mockList)
        .clear();

    // then
    assertThrows(
        UnsupportedOperationException.class,
        () -> mockList.clear());
  }

  @Test
  @DisplayName("ArgumentMatchers.any() 메서드로 인자 값 매칭 처리")
  void givenAnyGameLevelWhenGameNumGenerateThenReturnGameNum() {
    // given
    GameNumGen genMock = mock(GameNumGen.class);
    given(genMock.generate(any())).willReturn("456");

    // when
    String num = genMock.generate(GameLevel.EASY);
    assertEquals("456", num);

    // then
    String num2 = genMock.generate(GameLevel.NORMAL);
    assertEquals("456", num2);
  }

  @Test
  @DisplayName("임의 값 일치와 정확한 값 일치가 필요한 경우 eq() 메서드를 사용")
  void givenListWhenListSetThenReturnString() {
    // given
    List<String> mockList = mock(List.class);
    // set(int index, element)
//    given(mockList.set(anyInt(), "123")).willReturn("456");
    given(mockList.set(anyInt(), eq("123"))).willReturn("456");

    // when
    String old = mockList.set(5, "123");

    // then
    assertEquals("456", old);
  }

  @Test
  @DisplayName("모의 객체의 메서드가 불렸는지 여부를 검증하는 코드")
  void givenGameWhenGameInitThenCallGenerate() {
    // given
    GameNumGen genMock = mock(GameNumGen.class);
    Game game = new Game(genMock);

    // when
    game.init(GameLevel.EASY);

    // then
    then(genMock).should().generate(GameLevel.EASY);
  }

}
