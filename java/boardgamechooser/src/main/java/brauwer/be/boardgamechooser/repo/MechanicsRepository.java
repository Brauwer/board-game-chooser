package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.Mechanics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicsRepository extends MongoRepository<Mechanics, String>, MechanicsRepoCustom {
}
