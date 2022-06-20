package brauwer.be.boardgamechooser.repo;

import brauwer.be.boardgamechooser.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepoCustom {

    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    List<Category> findCategoryByName(String name);

}
