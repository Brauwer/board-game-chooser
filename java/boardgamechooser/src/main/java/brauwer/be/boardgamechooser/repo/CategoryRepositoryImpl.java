package brauwer.be.boardgamechooser.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class CategoryRepositoryImpl implements CategoryRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CategoryRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }
}
