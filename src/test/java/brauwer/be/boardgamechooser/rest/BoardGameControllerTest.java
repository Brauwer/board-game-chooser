package brauwer.be.boardgamechooser.rest;

import brauwer.be.boardgamechooser.models.BoardGame;
import brauwer.be.boardgamechooser.repo.BoardGameRepository;
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

@ContextConfiguration(classes = {BoardGameController.class})
@ExtendWith(SpringExtension.class)
class BoardGameControllerTest {
  @Autowired
  private BoardGameController boardGameController;

  @MockBean
  private BoardGameRepository boardGameRepository;

  /**
   * Method under test: {@link BoardGameController#allBoardGames()}
   */
  @Test
  void testAllBoardGames() throws Exception {
    when(boardGameRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link BoardGameController#allBoardGames()}
   */
  @Test
  void testAllBoardGames2() throws Exception {
    when(boardGameRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/boardgames");
    getResult.characterEncoding("Encoding");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(getResult)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link BoardGameController#findBoardGame(String)}
   */
  @Test
  void testFindBoardGame() throws Exception {
    BoardGame boardGame = new BoardGame();
    boardGame.setAverageLearningComplexity("Average Learning Complexity");
    boardGame.setAverageStrategyComplexity("Average Strategy Complexity");
    boardGame.setBoardGameAtlasUrl("https://example.org/example");
    boardGame.setCategories(new ArrayList<>());
    boardGame.setDescription("The characteristics of someone or something");
    boardGame.setDescriptionPreview("Description Preview");
    boardGame.setDesigners(new ArrayList<>());
    boardGame.setId("42");
    boardGame.setImage("Image");
    boardGame.setImageUrls(new ArrayList<>());
    boardGame.setMaxPlayTime(3);
    boardGame.setMaxPlayers(3);
    boardGame.setMechanics(new ArrayList<>());
    boardGame.setMinAge(1);
    boardGame.setMinPlayTime(1);
    boardGame.setMinPlayers(1);
    boardGame.setName("Name");
    boardGame.setOfficialUrl("https://example.org/example");
    boardGame.setPlayTime("Play Time");
    boardGame.setPlayers("Players");
    boardGame.setPrimaryDesigner("Primary Designer");
    boardGame.setPrimaryPublisher("Primary Publisher");
    boardGame.setPublishers(new ArrayList<>());
    boardGame.setRank(1);
    boardGame.setRules("Rules");
    boardGame.setThumbnail("Thumbnail");
    boardGame.setType("Type");
    boardGame.setYearPublished(1);
    Optional<BoardGame> ofResult = Optional.of(boardGame);
    when(boardGameRepository.findById((String) any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames/{id}", "42");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":\"42\",\"boardGameAtlasUrl\":\"https://example.org/example\",\"name\":\"Name\",\"yearPublished\":1,\"minPlayers"
            + "\":1,\"maxPlayers\":3,\"minPlayTime\":1,\"maxPlayTime\":3,\"minAge\":1,\"description\":\"The characteristics of"
            + " someone or something\",\"descriptionPreview\":\"Description Preview\",\"thumbnail\":\"Thumbnail\",\"image\":"
            + "\"Image\",\"mechanics\":[],\"categories\":[],\"publishers\":[],\"designers\":[],\"primaryPublisher\":\"Primary"
            + " Publisher\",\"primaryDesigner\":\"Primary Designer\",\"rank\":1,\"type\":\"Type\",\"players\":\"Players\",\"playTime\":\"Play"
            + " Time\",\"imageUrls\":[],\"officialUrl\":\"https://example.org/example\",\"averageLearningComplexity\":\"Average"
            + " Learning Complexity\",\"averageStrategyComplexity\":\"Average Strategy Complexity\",\"rules\":\"Rules\"}"));
  }

  /**
   * Method under test: {@link BoardGameController#findBoardGamesByCategory(String)}
   */
  @Test
  void testFindBoardGamesByCategory() throws Exception {
    when(boardGameRepository.findByCategories((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames/category/{category}",
      "Category");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link BoardGameController#findBoardGamesByCategory(String)}
   */
  @Test
  void testFindBoardGamesByCategory2() throws Exception {
    BoardGame boardGame = new BoardGame();
    boardGame.setAverageLearningComplexity("Average Learning Complexity");
    boardGame.setAverageStrategyComplexity("Average Strategy Complexity");
    boardGame.setBoardGameAtlasUrl("https://example.org/example");
    boardGame.setCategories(new ArrayList<>());
    boardGame.setDescription("The characteristics of someone or something");
    boardGame.setDescriptionPreview("Description Preview");
    boardGame.setDesigners(new ArrayList<>());
    boardGame.setId("42");
    boardGame.setImage("Image");
    boardGame.setImageUrls(new ArrayList<>());
    boardGame.setMaxPlayTime(3);
    boardGame.setMaxPlayers(3);
    boardGame.setMechanics(new ArrayList<>());
    boardGame.setMinAge(1);
    boardGame.setMinPlayTime(1);
    boardGame.setMinPlayers(1);
    boardGame.setName("Name");
    boardGame.setOfficialUrl("https://example.org/example");
    boardGame.setPlayTime("Play Time");
    boardGame.setPlayers("Players");
    boardGame.setPrimaryDesigner("Primary Designer");
    boardGame.setPrimaryPublisher("Primary Publisher");
    boardGame.setPublishers(new ArrayList<>());
    boardGame.setRank(1);
    boardGame.setRules("Rules");
    boardGame.setThumbnail("Thumbnail");
    boardGame.setType("Type");
    boardGame.setYearPublished(1);
    Optional<BoardGame> ofResult = Optional.of(boardGame);
    when(boardGameRepository.findById((String) any())).thenReturn(ofResult);
    when(boardGameRepository.findByCategories((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames/category/{category}", "",
      "Uri Vars");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":\"42\",\"boardGameAtlasUrl\":\"https://example.org/example\",\"name\":\"Name\",\"yearPublished\":1,\"minPlayers"
            + "\":1,\"maxPlayers\":3,\"minPlayTime\":1,\"maxPlayTime\":3,\"minAge\":1,\"description\":\"The characteristics of"
            + " someone or something\",\"descriptionPreview\":\"Description Preview\",\"thumbnail\":\"Thumbnail\",\"image\":"
            + "\"Image\",\"mechanics\":[],\"categories\":[],\"publishers\":[],\"designers\":[],\"primaryPublisher\":\"Primary"
            + " Publisher\",\"primaryDesigner\":\"Primary Designer\",\"rank\":1,\"type\":\"Type\",\"players\":\"Players\",\"playTime\":\"Play"
            + " Time\",\"imageUrls\":[],\"officialUrl\":\"https://example.org/example\",\"averageLearningComplexity\":\"Average"
            + " Learning Complexity\",\"averageStrategyComplexity\":\"Average Strategy Complexity\",\"rules\":\"Rules\"}"));
  }

  /**
   * Method under test: {@link BoardGameController#findCategoryByName(String)}
   */
  @Test
  void testFindCategoryByName() throws Exception {
    when(boardGameRepository.findByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames/search/{name}", "Name");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link BoardGameController#findCategoryByName(String)}
   */
  @Test
  void testFindCategoryByName2() throws Exception {
    BoardGame boardGame = new BoardGame();
    boardGame.setAverageLearningComplexity("Average Learning Complexity");
    boardGame.setAverageStrategyComplexity("Average Strategy Complexity");
    boardGame.setBoardGameAtlasUrl("https://example.org/example");
    boardGame.setCategories(new ArrayList<>());
    boardGame.setDescription("The characteristics of someone or something");
    boardGame.setDescriptionPreview("Description Preview");
    boardGame.setDesigners(new ArrayList<>());
    boardGame.setId("42");
    boardGame.setImage("Image");
    boardGame.setImageUrls(new ArrayList<>());
    boardGame.setMaxPlayTime(3);
    boardGame.setMaxPlayers(3);
    boardGame.setMechanics(new ArrayList<>());
    boardGame.setMinAge(1);
    boardGame.setMinPlayTime(1);
    boardGame.setMinPlayers(1);
    boardGame.setName("Name");
    boardGame.setOfficialUrl("https://example.org/example");
    boardGame.setPlayTime("Play Time");
    boardGame.setPlayers("Players");
    boardGame.setPrimaryDesigner("Primary Designer");
    boardGame.setPrimaryPublisher("Primary Publisher");
    boardGame.setPublishers(new ArrayList<>());
    boardGame.setRank(1);
    boardGame.setRules("Rules");
    boardGame.setThumbnail("Thumbnail");
    boardGame.setType("Type");
    boardGame.setYearPublished(1);
    Optional<BoardGame> ofResult = Optional.of(boardGame);
    when(boardGameRepository.findById((String) any())).thenReturn(ofResult);
    when(boardGameRepository.findByName((String) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/boardgames/search/{name}", "",
      "Uri Vars");
    MockMvcBuilders.standaloneSetup(boardGameController)
      .build()
      .perform(requestBuilder)
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
      .andExpect(MockMvcResultMatchers.content()
        .string(
          "{\"id\":\"42\",\"boardGameAtlasUrl\":\"https://example.org/example\",\"name\":\"Name\",\"yearPublished\":1,\"minPlayers"
            + "\":1,\"maxPlayers\":3,\"minPlayTime\":1,\"maxPlayTime\":3,\"minAge\":1,\"description\":\"The characteristics of"
            + " someone or something\",\"descriptionPreview\":\"Description Preview\",\"thumbnail\":\"Thumbnail\",\"image\":"
            + "\"Image\",\"mechanics\":[],\"categories\":[],\"publishers\":[],\"designers\":[],\"primaryPublisher\":\"Primary"
            + " Publisher\",\"primaryDesigner\":\"Primary Designer\",\"rank\":1,\"type\":\"Type\",\"players\":\"Players\",\"playTime\":\"Play"
            + " Time\",\"imageUrls\":[],\"officialUrl\":\"https://example.org/example\",\"averageLearningComplexity\":\"Average"
            + " Learning Complexity\",\"averageStrategyComplexity\":\"Average Strategy Complexity\",\"rules\":\"Rules\"}"));
  }
}

