package brauwer.be.boardgamechooser.models;

import brauwer.be.boardgamechooser.json.Categories;
import brauwer.be.boardgamechooser.json.Designers;
import brauwer.be.boardgamechooser.json.Mechanics;
import brauwer.be.boardgamechooser.json.Publishers;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardGame {
    private String id;
    private String boardGameAtlasUrl;
    private String name;
    private int yearPublished;
    private int minPlayers;
    private int maxPlayers;
    private int minPlayTime;
    private int maxPlayTime;
    private int minAge;
    private String description;
    private String descriptionPreview;
    private String thumbnail;
    private String image;
    private List<Mechanics> mechanics;
    private List<Categories> categories;
    private List<Publishers> publishers;
    private List<Designers> designers;
    private String primaryPublisher;
    private String primaryDesigner;
    private int rank;
    private String type;
    private String players;
    private String playTime;
    private List<String> imageUrls;
    private String officialUrl;
    private String averageLearningComplexity;
    private String averageStrategyComplexity;
    private String rules;

}
