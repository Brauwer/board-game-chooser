package brauwer.be.boardgamechooser.jobs;

import brauwer.be.boardgamechooser.models.Mechanics;
import brauwer.be.boardgamechooser.repo.MechanicsRepository;
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
import java.nio.file.Files;
import java.nio.file.Path;

public class ImportMechanics {

    private static final Logger logger = LoggerFactory.getLogger(ImportMechanics.class);
    private static String clientId;

    static {
        try {
            clientId = Files.readString(Path.of("src/main/resources/static/clientId"));
        } catch (IOException e) {
            logger.error("Unable to fetch API token", e);
            System.exit(0);
        }
    }

    private static final String ATLAS_MECHANICS_URL = "https://api.boardgameatlas.com/api/game/mechanics?pretty=true&client_id=" + clientId;
    private MechanicsRepository mechanicsRepository;

    public boolean importMechanics(MechanicsRepository mechanicsRepository) {
        this.mechanicsRepository = mechanicsRepository;
        return doRequest(ATLAS_MECHANICS_URL);
    }

    private boolean doRequest(String urlRequest) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(urlRequest).get().build();

        logger.info("Request url: {}", urlRequest);

        try {
            Response response = client.newCall(request).execute();
            extractMechanics(response);
        } catch (IOException e) {
            logger.error("Error making request to import boardgames from Atlas API", e);
            return false;
        }
        return true;
    }

    private void extractMechanics(Response response) {
        try {
            Gson gson = new Gson();
            JSONParser jsonParser = new JSONParser();

            Object obj = jsonParser.parse(response.body().string());

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray events = (JSONArray) jsonObject.get("mechanics");
            for (JSONObject c : (Iterable<JSONObject>) events) {
                Mechanics mechanics = gson.fromJson(c.toJSONString(), Mechanics.class);
                mechanicsRepository.save(mechanics);
            }
        } catch (IOException e) {
            logger.error("IOException extracting mechanics", e);
        } catch (ParseException e) {
            logger.error("ParseException extracting mechanics", e);
        }
    }
}
