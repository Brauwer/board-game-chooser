package brauwer.be.boardgamechooser.jobs;

import brauwer.be.boardgamechooser.json.BoardGames;
import brauwer.be.boardgamechooser.json.Games;
import brauwer.be.boardgamechooser.models.BoardGame;
import brauwer.be.boardgamechooser.repo.BoardGameRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ImportBoardGames {

    private static final Logger logger = LoggerFactory.getLogger(ImportBoardGames.class);
    private static String clientId;

    static {
        try {
            clientId = Files.readString(Path.of("src/main/resources/static/clientId"));
        } catch (IOException e) {
            logger.error("Unable to fetch API token", e);
            System.exit(0);
        }
    }

    private static final int LIMIT = 100;
    private static final String ATLAS_API_URL = "https://api.boardgameatlas.com/api/search?limit=" + LIMIT +
            "&client_id=" + clientId;
    //TODO number to skip is limited to 1000, find another way when you want more :)
    private int numberToSkip = 0;

    private BoardGameRepository repository;

    public boolean importBoardGames(BoardGameRepository boardGameRepository) {
        this.repository = boardGameRepository;

        return doRequest(ATLAS_API_URL);

    }

    private boolean doRequest(String urlRequest) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(urlRequest).get().build();

        logger.info("Request url: {}", urlRequest);

        try {
            Response response = client.newCall(request).execute();
            extractBoardgames(response);
        } catch (IOException e) {
            logger.error("Error making request to import boardgames from Atlas API", e);
            return false;
        }
        return true;
    }

    private void extractBoardgames(Response response) {
        try {
            Gson gson = new Gson();
            BoardGames games = gson.fromJson(response.body().string(), BoardGames.class);
            if(games.getGames()!=null) {
                saveGames(games.getGames());
                checkForNextRequest(games.getCount());
            }
        } catch (Exception e) {
            logger.error("Error reading JSON", e);
        }
    }


    /**
     * Extract desired data and save to DB
     */
    private void saveGames(List<Games> games) {
        games.forEach(game -> {
            BoardGame boardGame = BoardGame.builder()
                    .id(game.getId())
                    .boardGameAtlasUrl(game.getUrl())
                    .name(game.getName())
                    .yearPublished(game.getYearPublished())
                    .minPlayers(game.getMinPlayers())
                    .maxPlayers(game.getMaxPlayers())
                    .minPlayTime(game.getMinPlaytime())
                    .minAge(game.getMinAge())
                    .description(game.getDescription())
                    .descriptionPreview(game.getDescriptionPreview())
                    .thumbnail(game.getThumbUrl())
                    .image(game.getImageUrl())
                    .mechanics(game.getMechanics())
                    .categories(game.getCategories())
                    .publishers(game.getPublishers())
                    .designers(game.getDesigners())
                    .primaryPublisher(game.getPrimaryPublisher()!=null ? game.getPrimaryPublisher().getName() : null)
                    .primaryDesigner(game.getPrimaryDesigner()!=null ? game.getPrimaryDesigner().getName() : null)
                    .rank(game.getRank())
                    .type(game.getType())
                    .players(game.getPlayers())
                    .playTime(game.getPlaytime())
                    .officialUrl(game.getOfficialUrl())
                    .averageLearningComplexity(game.getAverageLearningComplexity())
                    .averageStrategyComplexity(game.getAverageStrategyComplexity())
                    .build();
            repository.save(boardGame);
        });
    }

    /**
     * Check if we need to make another request to get the remaining games
     * @param count holds the total number of boardgames
     */
    private void checkForNextRequest(int count) {
        numberToSkip = numberToSkip + LIMIT;

        if(count>numberToSkip){
            doRequest(ATLAS_API_URL + "&skip=" + numberToSkip);
        }
    }
}
