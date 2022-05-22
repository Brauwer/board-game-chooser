/* Copyright 2022 freecodeformat.com */
package brauwer.be.boardgamechooser.json;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/* Time: 2022-05-11 14:43:46 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Publishers {

    private String id;
    @JsonProperty("num_games")
    private String numGames;
    private int score;
    private Game game;
    private String url;
    private Images images;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setNumGames(String numGames) {
         this.numGames = numGames;
     }
     public String getNumGames() {
         return numGames;
     }

    public void setScore(int score) {
         this.score = score;
     }
     public int getScore() {
         return score;
     }

    public void setGame(Game game) {
         this.game = game;
     }
     public Game getGame() {
         return game;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setImages(Images images) {
         this.images = images;
     }
     public Images getImages() {
         return images;
     }

}