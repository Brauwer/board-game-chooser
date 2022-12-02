package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.Category;
import brauwer.be.boardgamechooser.repo.CategoryRepository;
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

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CategoryController.class})
@ExtendWith(SpringExtension.class)
class CategoryControllerTest {
  @Autowired
  private CategoryController categoryController;

  @MockBean
  private CategoryRepository categoryRepository;

  /**
   * Method under test: {@link CategoryController#allCategories()}
   */
  @Test
  void testAllCategories() throws Exception {
    when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories");
    MockMvcBuilders.standaloneSetup(categoryController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link CategoryController#findCategoryByName(String)}
   */
  @Test
  void testFindCategoryByName() throws Exception {
    when(categoryRepository.findCategoryByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories/search/*");
    MockMvcBuilders.standaloneSetup(categoryController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link CategoryController#findCategoryByName(String)}
   */
  @Test
  void testFindCategoryByName2() throws Exception {
    when(categoryRepository.findCategoryByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/categories/search/*");
    getResult.characterEncoding("Encoding");
    MockMvcBuilders.standaloneSetup(categoryController)
      .build()
      .perform(getResult)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link CategoryController#allCategories()}
   */
  @Test
  void testAllCategories2() throws Exception {
    when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/categories");
    getResult.characterEncoding("Encoding");
    MockMvcBuilders.standaloneSetup(categoryController)
      .build()
      .perform(getResult)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link CategoryController#findCategoryById(String)}
   */
  @Test
  void testFindCategoryById() throws Exception {
    when(categoryRepository.findById((String) any()))
      .thenReturn(Optional.of(new Category("42", "Name", "https://example.org/example")));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories/*");
    MockMvcBuilders.standaloneSetup(categoryController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string("{\"id\":\"42\",\"name\":\"Name\",\"url\":\"https://example.org/example\"}"));
  }
}

