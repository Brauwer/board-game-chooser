/* Copyright 2022 freecodeformat.com */
package brauwer.be.boardgamechooser.json;
import java.util.List;

/* Time: 2022-05-11 14:43:46 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class BoardGames {

    private List<Games> games;
    private int count;
    public void setGames(List<Games> games) {
         this.games = games;
     }
     public List<Games> getGames() {
         return games;
     }

    public void setCount(int count) {
         this.count = count;
     }
     public int getCount() {
         return count;
     }

}