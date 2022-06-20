package brauwer.be.boardgamechooser.jobs;

import brauwer.be.boardgamechooser.models.Category;
import brauwer.be.boardgamechooser.repo.CategoryRepository;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImportCategories {

    private static final Logger logger = LoggerFactory.getLogger(ImportCategories.class);
    private static String clientId;

    static {
        try {
            clientId = Files.readString(Path.of("C:\\development\\Java\\Git\\board-game-chooser\\java\\boardgamechooser\\src\\main\\resources\\clientId"));
        } catch (IOException e) {
            logger.error("Unable to fetch API token", e);
            System.exit(0);
        }
    }

    private static final String ATLAS_CATEGORIES_URL = "https://api.boardgameatlas.com/api/game/categories?pretty=true&client_id=" + clientId;
    private CategoryRepository categoryRepository;

    public boolean importCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        return doRequest(ATLAS_CATEGORIES_URL);
    }

    private boolean doRequest(String urlRequest) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(urlRequest).get().build();

        logger.info("Request url: {}", urlRequest);

        try {
            Response response = client.newCall(request).execute();
            extractCategories(response);
        } catch (IOException e) {
            logger.error("Error making request to import boardgames from Atlas API", e);
            return false;
        }
        return true;
    }

    private void extractCategories(Response response) {
        try {
            Gson gson = new Gson();
            JSONParser jsonParser = new JSONParser();

            Object obj = jsonParser.parse(response.body().string());

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray events = (JSONArray) jsonObject.get("categories");
            for (JSONObject c : (Iterable<JSONObject>) events) {
                        Category category = gson.fromJson(c.toJSONString(), Category.class);
                        categoryRepository.save(category);
            }
        } catch (IOException e) {
            logger.error("IOException extracting categories", e);
        } catch (ParseException e) {
            logger.error("ParseException extracting categories", e);
        }
    }
}
