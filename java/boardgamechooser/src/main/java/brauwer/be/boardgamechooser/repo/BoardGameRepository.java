package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.BoardGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends MongoRepository<BoardGame, String>, BoardGameRepoCustom {}
