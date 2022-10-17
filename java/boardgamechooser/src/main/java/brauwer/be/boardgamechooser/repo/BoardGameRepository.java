package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.BoardGame;
import brauwer.be.boardgamechooser.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardGameRepository extends MongoRepository<BoardGame, String>, BoardGameRepoCustom {
    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    List<Category> findByName(String name);
}
