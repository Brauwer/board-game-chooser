package brauwer.be.boardgamechooser.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class MechanicsRepositoryImpl implements MechanicsRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MechanicsRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }
}
