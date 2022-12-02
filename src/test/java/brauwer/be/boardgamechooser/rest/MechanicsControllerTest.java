package brauwer.be.boardgamechooser.rest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import brauwer.be.boardgamechooser.models.Mechanics;
import brauwer.be.boardgamechooser.repo.MechanicsRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MechanicsController.class})
@ExtendWith(SpringExtension.class)
class MechanicsControllerTest {
  @Autowired
  private MechanicsController mechanicsController;

  @MockBean
  private MechanicsRepository mechanicsRepository;

  /**
   * Method under test: {@link MechanicsController#allCategories()}
   */
  @Test
  void testAllCategories() throws Exception {
    when(mechanicsRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mechanics");
    MockMvcBuilders.standaloneSetup(mechanicsController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link MechanicsController#findMechanicsByName(String)}
   */
  @Test
  void testFindMechanicsByName() throws Exception {
    when(mechanicsRepository.findMechanicsByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mechanics/search/*");
    MockMvcBuilders.standaloneSetup(mechanicsController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link MechanicsController#findMechanicsByName(String)}
   */
  @Test
  void testFindMechanicsByName2() throws Exception {
    when(mechanicsRepository.findMechanicsByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/mechanics/search/*");
    getResult.characterEncoding("Encoding");
    MockMvcBuilders.standaloneSetup(mechanicsController)
      .build()
      .perform(getResult)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link MechanicsController#allCategories()}
   */
  @Test
  void testAllCategories2() throws Exception {
    when(mechanicsRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/mechanics");
    getResult.characterEncoding("Encoding");
    MockMvcBuilders.standaloneSetup(mechanicsController)
      .build()
      .perform(getResult)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link MechanicsController#findMechanicsById(String)}
   */
  @Test
  void testFindMechanicsById() throws Exception {
    when(mechanicsRepository.findById((String) any()))
      .thenReturn(Optional.of(new Mechanics("42", "Name", "https://example.org/example")));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mechanics/*");
    MockMvcBuilders.standaloneSetup(mechanicsController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string("{\"id\":\"42\",\"name\":\"Name\",\"url\":\"https://example.org/example\"}"));
  }
}

