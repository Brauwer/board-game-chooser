package brauwer.be.boardgamechooser.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private String id;
  private String username;
  private String email;
  private String password;
  private List<BoardGame> ownedBoardGames;
  private List<BoardGame> wishList;
  private List<User> friends;
}
