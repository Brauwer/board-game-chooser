package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepoCustom {
}
