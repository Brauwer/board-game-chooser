package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.Mechanics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicsRepository extends MongoRepository<Mechanics, String>, MechanicsRepoCustom {

    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    List<Mechanics> findMechanicsByName(String name);
}
