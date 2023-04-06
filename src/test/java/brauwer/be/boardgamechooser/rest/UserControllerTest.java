package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.User;
import brauwer.be.boardgamechooser.repo.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
  @Autowired
  private UserController userController;

  @MockBean
  private UserRepository userRepository;

  /**
   * Method under test: {@link UserController#findUserByEmail(String)}
   */
  @Test
  void testFindUserByEmail() throws Exception {
    when(userRepository.findByEmail(any())).thenReturn(Optional.of(new User()));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/search/email/*");
    MockMvcBuilders.standaloneSetup(userController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":null,\"username\":null,\"email\":null,\"password\":null,\"ownedBoardGames\":null,\"wishList\":null,\"friends"
            + "\":null}"));
  }

  /**
   * Method under test: {@link UserController#findUserById(String)}
   */
  @Test
  void testFindUserById() throws Exception {
    when(userRepository.findById(any())).thenReturn(Optional.of(new User()));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/*");
    MockMvcBuilders.standaloneSetup(userController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":null,\"username\":null,\"email\":null,\"password\":null,\"ownedBoardGames\":null,\"wishList\":null,\"friends"
            + "\":null}"));
  }

  /**
   * Method under test: {@link UserController#findUserByUsername(String)}
   */
  @Test
  void testFindUserByUsername() throws Exception {
    when(userRepository.findByUsername(any())).thenReturn(Optional.of(new User()));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/search/username/*");
    MockMvcBuilders.standaloneSetup(userController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":null,\"username\":null,\"email\":null,\"password\":null,\"ownedBoardGames\":null,\"wishList\":null,\"friends"
            + "\":null}"));
  }

  /**
   * Method under test: {@link UserController#saveUser(User)}
   */
  @Test
  void testSaveUser() throws Exception {
    when(userRepository.save((User) any())).thenReturn(new User());

    User user = new User();
    user.setEmail("jane.doe@example.org");
    user.setFriends(new ArrayList<>());
    user.setId("42");
    user.setOwnedBoardGames(new ArrayList<>());
    user.setPassword("iloveyou");
    user.setUsername("janedoe");
    user.setWishList(new ArrayList<>());
    String content = (new ObjectMapper()).writeValueAsString(user);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/save")
      .contentType(MediaType.APPLICATION_JSON)
      .content(content);
    MockMvcBuilders.standaloneSetup(userController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":null,\"username\":null,\"email\":null,\"password\":null,\"ownedBoardGames\":null,\"wishList\":null,\"friends"
            + "\":null}"));
  }
}

