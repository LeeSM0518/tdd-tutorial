package mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class UserRegisterMockTest {

  @Mock
  private WeakPasswordChecker mockWeakPasswordChecker;
  @Mock
  private UserRepository mockUserRepository;
  @Mock
  private EmailNotifier mockEmailNotifier;
  private UserRegister userRegister;

  @BeforeEach
  void createUserRegister() {
    userRegister = new UserRegister(mockWeakPasswordChecker,
        mockUserRepository,
        mockEmailNotifier);
  }

  @Test
  @DisplayName("가입하면 메일을 전송함")
  void givenIdAndPwAndEmailWhenRegisterThenSendEmail() {
    // given
    String id = "id";
    String pw = "pw";
    String email = "email@email.com";

    // when
    userRegister.register(id, pw, email);

    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    then(mockEmailNotifier)
        .should().sendRegisterEmail(captor.capture());
    String realEmail = captor.getValue();

    // then
    assertEquals("email@email.com", realEmail);
  }

}
