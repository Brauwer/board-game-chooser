package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.BoardGame;

import java.util.List;

public interface BoardGameRepoCustom {
    List<BoardGame> findByCategories(String category);
}
